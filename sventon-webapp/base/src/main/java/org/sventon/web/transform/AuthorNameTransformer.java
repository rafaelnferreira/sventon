/*
 * ====================================================================
 * Copyright (c) 2005-2011 sventon project. All rights reserved.
 *
 * This software is licensed as described in the file LICENSE, which
 * you should have received as part of this distribution. The terms
 * are also available at http://www.sventon.org.
 * If newer versions of this license are posted there, you may use a
 * newer version instead, at your option.
 * ====================================================================
 */
package org.sventon.web.transform;

/**
 * Used to enable transformation of the author name displayed in the web GUI.
 *
 * @author jesper@sventon.org
 */
public interface AuthorNameTransformer {

  /**
   * @param authorName Author name to transform.
   * @return Transformed author name.
   */
  String transform(final String authorName);

}