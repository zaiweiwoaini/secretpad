/*
 * Copyright 2023 Ant Group Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.secretflow.secretpad.persistence.repository;

import org.secretflow.secretpad.persistence.entity.ProjectNodeDO;
import org.secretflow.secretpad.persistence.entity.ProjectNodeDO.UPK;
import org.secretflow.secretpad.persistence.projection.ProjectNodeProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Project node repository
 *
 * @author yansi
 * @date 2023/6/8
 */
@Repository
public interface ProjectNodeRepository extends JpaRepository<ProjectNodeDO, UPK> {
    /**
     * Query project node results by projectId
     *
     * @param projectId target projectId
     * @return project node results
     */
    @Query("from ProjectNodeDO pn where pn.upk.projectId=:projectId")
    List<ProjectNodeDO> findByProjectId(@Param("projectId") String projectId);

    /**
     * Query ProjectNodeProjection list in project node table by projectId
     *
     * @param projectId target projectId
     * @return ProjectNodeProjection list in project node table
     */
    @Query("select new org.secretflow.secretpad.persistence.projection.ProjectNodeProjection(pn, n.name) from ProjectNodeDO pn join NodeDO n "
            + "on pn.upk.nodeId=n.nodeId and pn.upk.projectId=:projectId")
    List<ProjectNodeProjection> findProjectionByProjectId(@Param("projectId") String projectId);

    @Query("from ProjectNodeDO pn where pn.upk.nodeId=:nodeId")
    List<ProjectNodeDO> findByNodeId(@Param("nodeId") String nodeId);
}