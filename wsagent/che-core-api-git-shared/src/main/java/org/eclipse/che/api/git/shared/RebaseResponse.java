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
package org.eclipse.che.api.git.shared;

import java.util.List;
import org.eclipse.che.dto.shared.DTO;

/**
 * Info received from rebase response
 *
 * @author Dror Cohen
 */
@DTO
public interface RebaseResponse {
  enum RebaseStatus {
    OK("OK"),
    ABORTED("Aborted"),
    FAST_FORWARD("Fast-forward"),
    ALREADY_UP_TO_DATE("Already up-to-date"),
    NOTHING_TO_COMMIT("Nothing to commit"),
    FAILED("Failed"),
    MERGED("Merged"),
    CONFLICTING("Conflicting"),
    STOPPED("Stopped"),
    UNCOMMITTED_CHANGES("Uncommitted Changes"),
    NOT_SUPPORTED("Not-yet-supported"),
    EDITED("Edited"),
    INTERACTIVE_PREPARED("Interactive prepared"),
    STASH_APPLY_CONFLICTS("Stash apply conflicts");

    private final String value;

    RebaseStatus(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  RebaseStatus getStatus();

  void setStatus(RebaseStatus status);

  RebaseResponse withStatus(RebaseStatus status);

  /**
   * Files that have conflicts.
   *
   * @return list of files that have conflicts. Empty collection if there are no conflicts
   */
  List<String> getConflicts();

  void setConflicts(List<String> conflicts);

  RebaseResponse withConflicts(List<String> conflicts);

  /**
   * Files that failed to merge.
   *
   * @return list of files that failed to merge. Empty collection if there are no failed files
   */
  List<String> getFailed();

  void setFailed(List<String> failed);

  RebaseResponse withFailed(List<String> failed);
}
