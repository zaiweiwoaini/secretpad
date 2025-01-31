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

package org.secretflow.secretpad.web.controller;

import org.secretflow.secretpad.common.util.ProtoUtils;
import org.secretflow.secretpad.service.GraphService;
import org.secretflow.secretpad.service.model.common.SecretPadResponse;
import org.secretflow.secretpad.service.model.graph.*;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Graph controller
 *
 * @author yansi
 * @date 2023/5/24
 */
@RestController
@RequestMapping(value = "/api/v1alpha1")
public class GraphController {

    @Autowired
    private GraphService graphService;

    /**
     * List component international config api
     *
     * @return successful SecretPadResponse with component international config
     */
    @PostMapping("/component/i18n")
    @Operation(summary = "component international config")
    public SecretPadResponse<Object> listComponentI18n() {
        return SecretPadResponse.success(graphService.listComponentI18n());
    }

    /**
     * List component api
     *
     * @return successful SecretPadResponse with component list view object
     */
    @PostMapping("/component/list")
    @Operation(summary = "component list")
    public SecretPadResponse<CompListVO> listComponents() {
        return SecretPadResponse.success(graphService.listComponents());
    }

    /**
     * Query component detail api
     *
     * @param request get component request
     * @return successful SecretPadResponse with component detail
     */
    @Operation(summary = "component detail")
    @PostMapping("/component/get")
    public SecretPadResponse<Object> getComponent(@Valid @RequestBody GetComponentRequest request) {
        return SecretPadResponse.success(ProtoUtils.protoToMap(graphService.getComponent(request)));
    }

    /**
     * Batch query component detail list api
     *
     * @param request get component request list
     * @return successful SecretPadResponse with component detail list
     */
    @Operation(summary = "component detail list")
    @PostMapping("/component/batch")
    public SecretPadResponse<Object> batchGetComponent(@Valid @RequestBody List<GetComponentRequest> request) {
        return SecretPadResponse.success(ProtoUtils.protosToListMap(graphService.batchGetComponent(request)));
    }

    /**
     * Create a new graph api
     *
     * @param request create graph request
     * @return successful SecretPadResponse with create graph view object
     */
    @Operation(summary = "create graph")
    @PostMapping("/graph/create")
    public SecretPadResponse<CreateGraphVO> createGraph(@Valid @RequestBody CreateGraphRequest request) {
        return SecretPadResponse.success(graphService.createGraph(request));
    }

    /**
     * Delete graph api
     *
     * @param request delete graph request
     * @return successful SecretPadResponse with null data
     */
    @Operation(summary = "delete graph")
    @PostMapping("/graph/delete")
    public SecretPadResponse deleteGraph(@Valid @RequestBody DeleteGraphRequest request) {
        graphService.deleteGraph(request);
        return SecretPadResponse.success();
    }

    /**
     * List graph api
     *
     * @param request list graph request
     * @return successful SecretPadResponse with graph meta view object list
     */
    @Operation(summary = "graph list")
    @PostMapping("/graph/list")
    public SecretPadResponse<List<GraphMetaVO>> listGraph(@Valid @RequestBody ListGraphRequest request) {
        return SecretPadResponse.success(graphService.listGraph(request));
    }

    /**
     * Update graph meta information api
     *
     * @param request update graph meta request
     * @return successful SecretPadResponse with null data
     */
    @Operation(summary = "update graph meta information")
    @PostMapping("/graph/meta/update")
    public SecretPadResponse updateGraphMeta(@Valid @RequestBody UpdateGraphMetaRequest request) {
        graphService.updateGraphMeta(request);
        return SecretPadResponse.success();
    }

    /**
     * Fully update graph api
     *
     * @param request full update graph request
     * @return successful SecretPadResponse with null data
     */
    @Operation(summary = "fully update graph")
    @PostMapping("/graph/update")
    public SecretPadResponse fullUpdateGraph(@Valid @RequestBody FullUpdateGraphRequest request) {
        graphService.fullUpdateGraph(request);
        return SecretPadResponse.success();
    }

    /**
     * Update graph node api
     *
     * @param request update graph node request
     * @return successful SecretPadResponse with null data
     */
    @Operation(summary = "update graph node")
    @PostMapping("/graph/node/update")
    public SecretPadResponse<Void> updateGraphNode(@Valid @RequestBody UpdateGraphNodeRequest request) {
        graphService.updateGraphNode(request);
        return SecretPadResponse.success();
    }

    /**
     * Start graph api
     *
     * @param request start graph request
     * @return successful SecretPadResponse with start graph view object
     */
    @Operation(summary = "start graph")
    @PostMapping("/graph/start")
    public SecretPadResponse<StartGraphVO> startGraph(@Valid @RequestBody StartGraphRequest request) {
        return SecretPadResponse.success(graphService.startGraph(request));
    }

    /**
     * List graph node status api
     *
     * @param request list graph node status request
     * @return successful SecretPadResponse with graph status
     */
    @Operation(summary = "graph node status")
    @PostMapping("/graph/node/status")
    public SecretPadResponse<GraphStatus> listGraphNodeStatus(@Valid @RequestBody ListGraphNodeStatusRequest request) {
        return SecretPadResponse.success(graphService.listGraphNodeStatus(request));
    }

    /**
     * Stop graph node api
     *
     * @param request stop graph node request
     * @return successful SecretPadResponse with null data
     */
    @Operation(summary = "stop graph")
    @PostMapping("/graph/stop")
    public SecretPadResponse<Void> stopGraphNode(@Valid @RequestBody StopGraphNodeRequest request) {
        graphService.stopGraphNode(request);
        return SecretPadResponse.success();
    }

    /**
     * Query graph detail api
     *
     * @param request get graph detail request
     * @return successful SecretPadResponse with graph detail view object
     */
    @Operation(summary = "graph detail")
    @PostMapping("/graph/detail")
    public SecretPadResponse<GraphDetailVO> getGraphDetail(@Valid @RequestBody GetGraphRequest request) {
        return SecretPadResponse.success(graphService.getGraphDetail(request));
    }

    /**
     * Query graph node output api
     *
     * @param request query graph node output request
     * @return successful SecretPadResponse with graph node output view object
     */
    @Operation(summary = "graph node output")
    @PostMapping("/graph/node/output")
    public SecretPadResponse<GraphNodeOutputVO> getGraphNodeOutput(@Valid @RequestBody GraphNodeOutputRequest request) {
        return SecretPadResponse.success(graphService.getGraphNodeOutput(request));
    }

    /**
     * Query graph node logs api
     *
     * @param request query graph node logs request
     * @return successful SecretPadResponse with graph node task logs view object
     */
    @Operation(summary = "graph node logs")
    @PostMapping("/graph/node/logs")
    public SecretPadResponse<GraphNodeTaskLogsVO> getGraphNodeLogs(@Valid @RequestBody GraphNodeLogsRequest request) {
        return SecretPadResponse.success(graphService.getGraphNodeLogs(request));
    }

}
