/*******************************************************************************
 * Copyright (c) 2008, 2014 Stuart McCulloch
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Stuart McCulloch - initial API and implementation
 *******************************************************************************/

package org.eclipse.sisu.peaberry.eclipse;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtension;

/**
 * Wraps an Extension to behave like an aggregation of configuration elements.
 * 
 * @author mcculls@gmail.com (Stuart McCulloch)
 */
final class AggregatedExtension
    implements IConfigurationElement {

  private final IExtension extension;

  AggregatedExtension(final IExtension extension) {
    this.extension = extension;
  }

  public Object createExecutableExtension(final String name) {
    throw new UnsupportedOperationException();
  }

  public String getAttribute(final String name) {
    return null;
  }

  public String getAttribute(final String name, final String locale) {
    return null;
  }

  @SuppressWarnings("deprecation")
  public String getAttributeAsIs(final String name) {
    return null;
  }

  public String[] getAttributeNames() {
    return new String[0];
  }

  public IConfigurationElement[] getChildren() {
    return extension.getConfigurationElements();
  }

  public IConfigurationElement[] getChildren(final String name) {
    final List<IConfigurationElement> children = new ArrayList<IConfigurationElement>();
    for (final IConfigurationElement e : extension.getConfigurationElements()) {
      children.add(e);
    }
    return children.toArray(new IConfigurationElement[children.size()]);
  }

  public IContributor getContributor() {
    return extension.getContributor();
  }

  public IExtension getDeclaringExtension() {
    return extension;
  }

  public String getName() {
    return extension.getLabel();
  }

  @SuppressWarnings("deprecation")
  public String getNamespace() {
    return extension.getNamespace();
  }

  public String getNamespaceIdentifier() {
    return extension.getNamespaceIdentifier();
  }

  public Object getParent() {
    throw new UnsupportedOperationException();
  }

  public String getValue() {
    return null;
  }

  public String getValue(final String locale) {
    return null;
  }

  @SuppressWarnings("deprecation")
  public String getValueAsIs() {
    return null;
  }

  public boolean isValid() {
    return extension.isValid();
  }

  @Override
  public String toString() {
    return extension.toString();
  }

  @Override
  public boolean equals(final Object rhs) {
    if (rhs instanceof AggregatedExtension) {
      return extension.equals(((AggregatedExtension) rhs).extension);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return extension.hashCode();
  }
}
