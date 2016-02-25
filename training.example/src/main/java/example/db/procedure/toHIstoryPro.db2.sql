
wf_h_activityinst
wf_h_notificationinst
wf_h_bizinfo
wf_h_optmsg
wf_h_processinst
wf_h_processinstattr
wf_h_transctrl
wf_h_transition
wf_h_workitem
wf_h_wiparticipant


1、将在线表中的已完成的流程实例数据插入到历史表
2、删除在线表的数据


--工作项表
INSERT INTO WF_H_WorkItem (workItemID, workItemName, workItemType, workItemDesc, currentState, participant, partiName, priority, isTimeOut, limitNum, limitNumDesc, createTime, startTime, endTime, finalTime, remindTime, actionURL, processInstID, activityInstID, statesList, timeOutNum, timeOutNumDesc, processInstName, activityInstName, processDefID, processDefName, processChName, activityDefID, assistant, assistantName, bizState, allowAgent, rootProcInstID, actionMask, urlType, dealResult, dealOpinion, extend1, extend2, extend3, extend4, extend5, extend6, extend7, catalogUUID, catalogName, tenant_id, alertFlag, pressNum, taskPoolID, belong, updateTime, acceptTime) SELECT workItemID, workItemName, workItemType, workItemDesc, currentState, participant, partiName, priority, isTimeOut, limitNum, limitNumDesc, createTime, startTime, endTime, finalTime, remindTime, actionURL, processInstID, activityInstID, statesList, timeOutNum, timeOutNumDesc, processInstName, activityInstName, processDefID, processDefName, processChName, activityDefID, assistant, assistantName, bizState, allowAgent, rootProcInstID, actionMask, urlType, dealResult, dealOpinion, extend1, extend2, extend3, extend4, extend5, extend6, extend7, catalogUUID, catalogName, tenant_id, alertFlag, pressNum, taskPoolID, belong, updateTime, acceptTime FROM WFWorkItem WHERE processInstID = proinstid

--连线控制表
INSERT INTO WF_H_TransCtrl (transCtrlID, srcActDefID, destActDefID, srcActDefName, destActDefName, lastTransTime, transWeight, processInstID, extend1, tenant_id) SELECT transCtrlID, srcActDefID, destActDefID, srcActDefName, destActDefName, lastTransTime, transWeight, processInstID, extend1, tenant_id FROM WFTransCtrl WHERE processInstID = proinstid

--连线表
INSERT INTO WF_H_Transition (transitionID, transitionType, causeActInstID, causeActInstName, resultActInstID, resultActInstName, srcActDefID, destActDefID, srcActDefName, destActDefName, transTime, processInstID, extend1, tenant_id) SELECT transitionID, transitionType, causeActInstID, causeActInstName, resultActInstID, resultActInstName, srcActDefID, destActDefID, srcActDefName, destActDefName, transTime, processInstID, extend1, tenant_id FROM WFTransition WHERE processInstID = proinstid

--活动实例表
INSERT INTO WF_H_ActivityInst (activityInstID, activityInstName, activityInstDesc, activityType, currentState, priority, createTime, startTime, endTime, finalTime, subProcessID, activityDefID, processInstID, rollbackFlag, extend1, extend2, extend3, extend4, extend5, extend6, extend7, catalogUUID, catalogName, tenant_id, relateData, updateTime) SELECT activityInstID, activityInstName, activityInstDesc, activityType, currentState, priority, createTime, startTime, endTime, finalTime, subProcessID, activityDefID, processInstID, rollbackFlag, extend1, extend2, extend3, extend4, extend5, extend6, extend7, catalogUUID, catalogName, tenant_id, relateData, updateTime FROM WFActivityInst WHERE processInstID = proinstid

--流程属性表
INSERT INTO WF_H_ProcessInstAttr (processInstID, attribute, extend1, extend2, extend3, tenant_id) SELECT processInstID, attribute, extend1, extend2, extend3, tenant_id FROM WFProcessInstAttr WHERE processInstID = proinstid

--流程实例表
INSERT INTO WF_H_ProcessInst (processInstID, processInstName, processInstDesc, creator, owner, currentState, priority, relateData, relateDataVChr, limitNum, limitNumDesc, createTime, startTime, endTime, finalTime, remindTime, parentProcID, parentActID, processDefID, isTimeOut, timeOutNum, timeOutNumDesc, updateVersion, processDefName, extend1, extend2, extend3, extend4, extend5, extend6, extend7, catalogUUID, catalogName, tenant_id, belong, alertFlag, errorFlag, updateTime) SELECT processInstID, processInstName, processInstDesc, creator, owner, currentState, priority, relateData, relateDataVChr, limitNum, limitNumDesc, createTime, startTime, endTime, finalTime, remindTime, parentProcID, parentActID, processDefID, isTimeOut, timeOutNum, timeOutNumDesc, updateVersion, processDefName, extend1, extend2, extend3, extend4, extend5, extend6, extend7, catalogUUID, catalogName, tenant_id, belong, alertFlag, errorFlag, updateTime FROM WFProcessInst WHERE processInstID = proinstid

--操作日志表
INSERT INTO WF_H_OptMsg (messageID, producer, receiver, operationType, correlationType, correlationID, contant, createTime, processDefID, processInstID, activityInstID, workItemID, tenant_id, extend1, extend2, extend3, extend4, extend5 ) SELECT messageID, producer, receiver, operationType, correlationType, correlationID, contant, createTime, processDefID, processInstID, activityInstID, workItemID, tenant_id, extend1, extend2, extend3, extend4, extend5  FROM WFOptMsg WHERE processInstID = proinstid


--参与者表
INSERT INTO WF_H_WIParticipant (WIParticID, workItemID, participantType, participantID, participantName, partiInType, delegateType, participantIndex, globalID, workItemName, workItemType, workItemDesc, currentState, participant, priority, isTimeOut, limitNum, limitNumDesc, createTime, startTime, endTime, finalTime, remindTime, actionURL, processInstID, activityInstID, statesList, timeOutNum, timeOutNumDesc, processInstName, activityInstName, processDefID, processDefName, processChName, activityDefID, assistant, bizState, allowAgent, partiName, assistantName, rootProcInstID, actionMask, urlType, dealResult, dealOpinion, extend1, extend2, extend3, extend4, extend5, extend6, extend7, catalogUUID, catalogName, tenant_id, alertFlag, pressNum, taskPoolID, belong, updateTime, acceptTime) SELECT WIParticID, workItemID, participantType, participantID, participantName, partiInType, delegateType, participantIndex, globalID, workItemName, workItemType, workItemDesc, currentState, participant, priority, isTimeOut, limitNum, limitNumDesc, createTime, startTime, endTime, finalTime, remindTime, actionURL, processInstID, activityInstID, statesList, timeOutNum, timeOutNumDesc, processInstName, activityInstName, processDefID, processDefName, processChName, activityDefID, assistant, bizState, allowAgent, partiName, assistantName, rootProcInstID, actionMask, urlType, dealResult, dealOpinion, extend1, extend2, extend3, extend4, extend5, extend6, extend7, catalogUUID, catalogName, tenant_id, alertFlag, pressNum, taskPoolID, belong, updateTime, acceptTime FROM WFWIParticipant WHERE processInstID = proinstid; 
	
--bizinfo
insert into wf_h_bizinfo (processinstid, biztablename, vccolumn1, vccolumn2, vccolumn3, vccolumn4, vccolumn5, vccolumn6, vccolumn7, vccolumn8, vccolumn9, vccolumn10, nmcolumn1, nmcolumn2, nmcolumn3, nmcolumn4, nmcolumn5, nmcolumn6, nmcolumn7, nmcolumn8, nmcolumn9, nmcolumn10, dtcolumn1, dtcolumn2, dtcolumn3, dtcolumn4, dtcolumn5, dtcolumn6, dtcolumn7, dtcolumn8, dtcolumn9, dtcolumn10) select 	processinstid, biztablename, vccolumn1, vccolumn2, vccolumn3, vccolumn4, vccolumn5, vccolumn6, vccolumn7, vccolumn8, vccolumn9, vccolumn10, nmcolumn1, nmcolumn2, nmcolumn3, nmcolumn4, nmcolumn5, nmcolumn6, nmcolumn7, nmcolumn8, nmcolumn9, nmcolumn10, dtcolumn1, dtcolumn2, dtcolumn3, dtcolumn4, dtcolumn5, dtcolumn6, dtcolumn7, dtcolumn8, dtcolumn9, dtcolumn10 from wfbizinfo where processinstid = proinstid;
delete from wfbizinfo where processinstid = proinstid;;

--wf_h_notificationinst
insert into wf_h_notificationinst (NOTIFICATIONID, TYPE, TITLE, SENDER, RECIPIENT, STATE, CREATETIME, CONFIRMTIME, FINALTIME, REMINDTIME, MESSAGE, ACTIONURL, PROCDEFID, PROCINSTID, ACTINSTID, WORKITEMID, PROCDEFNAME, PROCINSTNAME, ACTINSTNAME, WORKITEMNAME, TIMEOUTFLAG, REMINDEDFLAG, TENANT_ID, EXTEND1, EXTEND2, EXTEND3, EXTEND4, EXTEND5) select NOTIFICATIONID, TYPE, TITLE, SENDER, RECIPIENT, STATE, CREATETIME, CONFIRMTIME, FINALTIME, REMINDTIME, MESSAGE, ACTIONURL, PROCDEFID, PROCINSTID, ACTINSTID, WORKITEMID, PROCDEFNAME, PROCINSTNAME, ACTINSTNAME, WORKITEMNAME, TIMEOUTFLAG, REMINDEDFLAG, TENANT_ID, EXTEND1, EXTEND2, EXTEND3, EXTEND4, EXTEND5 from wfnotificationinst where PROCINSTID = proinstid;
delete from wfnotificationinst where PROCINSTID = proinstid;	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
