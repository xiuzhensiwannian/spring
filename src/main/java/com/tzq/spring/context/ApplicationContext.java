package com.tzq.spring.context;

import com.tzq.spring.beans.factory.ListableBeanFactory;


/**
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 */

public interface ApplicationContext extends ListableBeanFactory {
}
