package org.testng.internal;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import javax.annotation.Nullable;
import org.testng.IInjectorFactory;

class GuiceBackedInjectorFactory implements IInjectorFactory {

  @Override
  public Injector getInjector(@Nullable Injector parent, Stage stage, Module... modules) {
    if (parent == null) {
      return Guice.createInjector(stage, modules);
    }
    return parent.createChildInjector(modules);
  }
}
