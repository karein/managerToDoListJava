package br.com.minicursojava.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.minicursojava.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

  @Autowired
  private IUserRepository userRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    var serveletPath = request.getServletPath();
    System.out.println("serveletPath" + serveletPath);

    // considerar todos os caminhos que iniciam com /tasks
    if (serveletPath.startsWith("/tasks/")) {
      // pega autorização
      var authorization = request.getHeader("Authorization");
      System.out.println(authorization);

      var authEncoded = authorization.substring("Basic".length()).trim();
      System.out.println(authEncoded);

      byte[] authDecoded = Base64.getDecoder().decode(authEncoded);
      System.out.println(authDecoded);

      var authString = new String(authDecoded);
      System.out.println(authString);

      String[] credentials = authString.split(":");
      String username = credentials[0];
      String password = credentials[1];
      System.out.println(username);
      System.out.println(password);
      // validar usuário
      var user = this.userRepository.findByUsername(username);
      if (user == null) {
        response.sendError(401);
      } else {
        // validar senha
        var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
        if (passwordVerify.verified) {
          request.setAttribute("idUser", user.getId());
          filterChain.doFilter(request, response);
        } else {
          response.sendError(401);
        }
      }
    } else {
      filterChain.doFilter(request, response);
    }
  }

}
