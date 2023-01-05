package com.tzq.spring.util;

/**
 * Simple strategy interface for resolving a String value.
 * Used by {@link com.tzq.spring.beans.factory.config.ConfigurableBeanFactory}.
 */
public interface StringValueResolver {

    String resolveStringValue(String strVal);

}
