/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.ide.ext.java.client.navigation.node;

import com.google.gwt.dom.client.Element;
import elemental.html.SpanElement;
import org.eclipse.che.ide.ext.java.client.JavaResources;
import org.eclipse.che.ide.ui.smartTree.data.AbstractTreeNode;
import org.eclipse.che.ide.ui.smartTree.presentation.HasPresentation;
import org.eclipse.che.ide.ui.smartTree.presentation.NodePresentation;
import org.eclipse.che.ide.util.dom.Elements;

/**
 * Abstract tree node for the navigation tree.
 *
 * @author Valeriy Svydenko
 */
public abstract class AbstractPresentationNode extends AbstractTreeNode implements HasPresentation {

  private NodePresentation nodePresentation;

  /** {@inheritDoc} */
  @Override
  public NodePresentation getPresentation(boolean update) {
    if (nodePresentation == null) {
      nodePresentation = new NodePresentation();
      updatePresentation(nodePresentation);
    }

    if (update) {
      updatePresentation(nodePresentation);
    }
    return nodePresentation;
  }

  /**
   * Update presentation name for the node.
   *
   * @param isFromSuper <code>true</code> if a member is inherited
   * @param presentation node presentation
   * @param presentableName name
   * @param resources project resources
   */
  public void updatePresentationField(
      boolean isFromSuper,
      NodePresentation presentation,
      String presentableName,
      JavaResources resources) {
    if (isFromSuper) {
      SpanElement highlightElement =
          Elements.createSpanElement(resources.css().presentableTextContainer());
      highlightElement.setInnerText(presentableName);
      presentation.setUserElement((Element) highlightElement);
    } else {
      presentation.setPresentableText(presentableName);
    }
  }
}
