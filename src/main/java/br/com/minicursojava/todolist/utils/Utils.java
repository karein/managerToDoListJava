package br.com.minicursojava.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

  public static void copyNonNullProperties(Object source, Object target) {
    // copia os valores/propriedades de um objeto para outro
    BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
  }

  public static String[] getNullPropertyNames(Object source) {
    final BeanWrapper src = new BeanWrapperImpl(source);

    PropertyDescriptor[] pds = src.getPropertyDescriptors();

    // Conjunto de propriedades nulas
    Set<String> emptyNames = new HashSet<>();

    for (PropertyDescriptor pd : pds) {
      Object srcValue = src.getPropertyValue(pd.getName());
      if (srcValue == null) {
        emptyNames.add(pd.getName());
      }
    }

    // tamanho do array result vai ser o mesmo do emptyNames
    String[] result = new String[emptyNames.size()];
    // convertendo o emptyNames para um array; Converte o conjunto de nomes das
    // propriedades para um arr de string
    return emptyNames.toArray(result);
  }
}
