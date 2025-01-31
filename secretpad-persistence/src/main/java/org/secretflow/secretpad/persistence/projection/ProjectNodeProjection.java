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

package org.secretflow.secretpad.persistence.projection;

import org.secretflow.secretpad.persistence.entity.ProjectNodeDO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Project node projection data
 *
 * @author yansi
 * @date 2023/5/30
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectNodeProjection {
    /**
     * Project node DO information
     */
    private ProjectNodeDO projectNodeDO;
    /**
     * Node name
     */
    private String nodeName;
}
