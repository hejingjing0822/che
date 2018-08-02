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
package org.eclipse.che.plugin.github.factory.resolver;

import static org.eclipse.che.dto.server.DtoFactory.newDto;

import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.che.api.workspace.shared.dto.ProjectConfigDto;
import org.eclipse.che.api.workspace.shared.dto.SourceStorageDto;

/**
 * Create {@link ProjectConfigDto} object from objects
 *
 * @author Florent Benoit
 */
public class GithubSourceStorageBuilder {

  /**
   * Create SourceStorageDto DTO by using data of a github url
   *
   * @param githubUrl an instance of {@link GithubUrl}
   * @return newly created source storage DTO object
   */
  public SourceStorageDto build(GithubUrl githubUrl) {
    // Create map for source storage dto
    Map<String, String> parameters = new HashMap<>(2);
    parameters.put("branch", githubUrl.getBranch());

    if (!Strings.isNullOrEmpty(githubUrl.getSubfolder())) {
      parameters.put("keepDir", githubUrl.getSubfolder());
    }
    return newDto(SourceStorageDto.class)
        .withLocation(githubUrl.repositoryLocation())
        .withType("git")
        .withParameters(parameters);
  }
}
