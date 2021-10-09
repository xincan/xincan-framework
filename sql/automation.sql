

-- ----------------------------
-- Table structure for QRTZ_BLOB_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
CREATE TABLE `QRTZ_BLOB_TRIGGERS`  (
                                       `SCHED_NAME` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                       `TRIGGER_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                       `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                       `BLOB_DATA` blob NULL,
                                       PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
                                       INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
                                       CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of QRTZ_BLOB_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_CALENDARS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
CREATE TABLE `QRTZ_CALENDARS`  (
                                   `SCHED_NAME` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                   `CALENDAR_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                   `CALENDAR` blob NOT NULL,
                                   PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of QRTZ_CALENDARS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_CRON_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
CREATE TABLE `QRTZ_CRON_TRIGGERS`  (
                                       `SCHED_NAME` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                       `TRIGGER_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                       `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                       `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                       `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                       PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
                                       CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of QRTZ_CRON_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_FIRED_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
CREATE TABLE `QRTZ_FIRED_TRIGGERS`  (
                                        `SCHED_NAME` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                        `ENTRY_ID` varchar(95) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                        `TRIGGER_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                        `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                        `INSTANCE_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                        `FIRED_TIME` bigint(13) NOT NULL,
                                        `SCHED_TIME` bigint(13) NOT NULL,
                                        `PRIORITY` int(11) NOT NULL,
                                        `STATE` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                        `JOB_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                        `JOB_GROUP` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                        `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                        `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                        PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
                                        INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
                                        INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
                                        INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
                                        INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
                                        INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
                                        INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of QRTZ_FIRED_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_JOB_DETAILS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
CREATE TABLE `QRTZ_JOB_DETAILS`  (
                                     `SCHED_NAME` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                     `JOB_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                     `JOB_GROUP` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                     `DESCRIPTION` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                     `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                     `IS_DURABLE` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                     `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                     `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                     `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                     `JOB_DATA` blob NULL,
                                     PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
                                     INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
                                     INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of QRTZ_JOB_DETAILS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_LOCKS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_LOCKS`;
CREATE TABLE `QRTZ_LOCKS`  (
                               `SCHED_NAME` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                               `LOCK_NAME` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                               PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of QRTZ_LOCKS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS`  (
                                             `SCHED_NAME` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                             `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                             PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_SCHEDULER_STATE
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
CREATE TABLE `QRTZ_SCHEDULER_STATE`  (
                                         `SCHED_NAME` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `INSTANCE_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
                                         `CHECKIN_INTERVAL` bigint(13) NOT NULL,
                                         PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of QRTZ_SCHEDULER_STATE
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_SIMPLE_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS`  (
                                         `SCHED_NAME` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `TRIGGER_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `REPEAT_COUNT` bigint(7) NOT NULL,
                                         `REPEAT_INTERVAL` bigint(12) NOT NULL,
                                         `TIMES_TRIGGERED` bigint(10) NOT NULL,
                                         PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
                                         CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of QRTZ_SIMPLE_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_SIMPROP_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS`  (
                                          `SCHED_NAME` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                          `TRIGGER_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                          `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                          `STR_PROP_1` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                          `STR_PROP_2` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                          `STR_PROP_3` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                          `INT_PROP_1` int(11) NULL DEFAULT NULL,
                                          `INT_PROP_2` int(11) NULL DEFAULT NULL,
                                          `LONG_PROP_1` bigint(20) NULL DEFAULT NULL,
                                          `LONG_PROP_2` bigint(20) NULL DEFAULT NULL,
                                          `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
                                          `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
                                          `BOOL_PROP_1` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                          `BOOL_PROP_2` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                          PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
                                          CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of QRTZ_SIMPROP_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for QRTZ_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
CREATE TABLE `QRTZ_TRIGGERS`  (
                                  `SCHED_NAME` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                  `JOB_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                  `JOB_GROUP` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                  `DESCRIPTION` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                  `NEXT_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
                                  `PREV_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
                                  `PRIORITY` int(11) NULL DEFAULT NULL,
                                  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                  `START_TIME` bigint(13) NOT NULL,
                                  `END_TIME` bigint(13) NULL DEFAULT NULL,
                                  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                  `MISFIRE_INSTR` smallint(2) NULL DEFAULT NULL,
                                  `JOB_DATA` blob NULL,
                                  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
                                  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
                                  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `QRTZ_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of QRTZ_TRIGGERS
-- ----------------------------

-- ----------------------------
-- Table structure for automation_alarm_strategy
-- ----------------------------
DROP TABLE IF EXISTS `automation_alarm_strategy`;
CREATE TABLE `automation_alarm_strategy`  (
                                              `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                              `business_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务名称',
                                              `business_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '业务编码',
                                              `indicator` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '指标编码',
                                              `judge_role` int(2) NULL DEFAULT NULL COMMENT '1 等于 2 不等于 3包含 4 不包含 5大于 6小于  7大于等于 8小于等于',
                                              `threshold` int(11) NULL DEFAULT NULL COMMENT '域值',
                                              `alarm_type` int(2) NULL DEFAULT NULL COMMENT '告警类型',
                                              `alarm_level` int(2) NULL DEFAULT NULL COMMENT '警级等级(0-正常，3-警告，4-次要，1-主要，2-严重)',
                                              `alarm_content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '告警内容',
                                              `is_delete` int(2) NULL DEFAULT NULL COMMENT '否是删除（0-删除，1-未删除）',
                                              `create_time` datetime(0) NULL DEFAULT NULL COMMENT '建时间创',
                                              `last_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                              `create_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
                                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_alarm_strategy
-- ----------------------------

-- ----------------------------
-- Table structure for automation_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `automation_dictionary`;
CREATE TABLE `automation_dictionary`  (
                                          `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                          `dictionary_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
                                          `dictionary_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '代码',
                                          `dictionary_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类型',
                                          `is_enable` int(1) NOT NULL COMMENT '是否启用：0停用，1启用',
                                          `parent_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '父id',
                                          `is_init` int(1) NULL DEFAULT 0 COMMENT '是否是内置：0否，1是',
                                          PRIMARY KEY (`id`) USING BTREE,
                                          UNIQUE INDEX `dictionary_code`(`dictionary_code`) USING BTREE,
                                          UNIQUE INDEX `dictionary_code_2`(`dictionary_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_dictionary
-- ----------------------------
INSERT INTO `automation_dictionary` VALUES ('pplc', '跑批流程', 'pplc', 'processType', 1, 'processTypeRoot', 1);
INSERT INTO `automation_dictionary` VALUES ('processTypeRoot', '流程分类根节点', 'root', 'processType', 1, '-1', 1);

-- ----------------------------
-- Table structure for automation_host
-- ----------------------------
DROP TABLE IF EXISTS `automation_host`;
CREATE TABLE `automation_host`  (
                                    `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                    `ip_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'ip',
                                    `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '账号',
                                    `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
                                    `port` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '端口',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_host
-- ----------------------------

-- ----------------------------
-- Table structure for automation_message
-- ----------------------------
DROP TABLE IF EXISTS `automation_message`;
CREATE TABLE `automation_message`  (
                                       `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
                                       `message_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '消息id',
                                       `task_exec_log_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务节点执行id',
                                       `biz_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '业务类型',
                                       `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_message
-- ----------------------------

-- ----------------------------
-- Table structure for automation_message_notice
-- ----------------------------
DROP TABLE IF EXISTS `automation_message_notice`;
CREATE TABLE `automation_message_notice`  (
                                              `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
                                              `channel` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '通知渠道：0站内信，1短信，2邮件',
                                              `receiver` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '通知人',
                                              `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '通知标题',
                                              `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '通知内容',
                                              `process_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程id',
                                              `notice_strategy` int(1) NULL DEFAULT NULL COMMENT '成功或者失败通知:0失败，1成功',
                                              `node_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                              `alarm_level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '告警级别（0-严重，1-次要，2-主要）',
                                              `exception_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '异常类型',
                                              `is_delete` int(1) NULL DEFAULT NULL,
                                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_message_notice
-- ----------------------------

-- ----------------------------
-- Table structure for automation_node_task_history
-- ----------------------------
DROP TABLE IF EXISTS `automation_node_task_history`;
CREATE TABLE `automation_node_task_history`  (
                                                 `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
                                                 `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程节点实例id',
                                                 `status` int(1) NULL DEFAULT NULL COMMENT '执行状态：0失败，1成功',
                                                 `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_node_task_history
-- ----------------------------

-- ----------------------------
-- Table structure for automation_pause_node
-- ----------------------------
DROP TABLE IF EXISTS `automation_pause_node`;
CREATE TABLE `automation_pause_node`  (
                                          `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
                                          `process_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程id',
                                          `task_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务id',
                                          `node_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程节点id',
                                          `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程实例id',
                                          `task_history_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务实例id',
                                          `process_node_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节点实例id',
                                          `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                          `status` int(1) NULL DEFAULT NULL COMMENT '节点状态',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_pause_node
-- ----------------------------

-- ----------------------------
-- Table structure for automation_pre_convergence_status
-- ----------------------------
DROP TABLE IF EXISTS `automation_pre_convergence_status`;
CREATE TABLE `automation_pre_convergence_status`  (
                                                      `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
                                                      `node_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '汇聚节点id',
                                                      `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '流程实例id',
                                                      `status` int(1) NOT NULL COMMENT '节点状态',
                                                      `create_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                                                      `update_time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '跟新时间',
                                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '流程非执行节点的执行状态：目前主要是分支和并行节点' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_pre_convergence_status
-- ----------------------------

-- ----------------------------
-- Table structure for automation_process
-- ----------------------------
DROP TABLE IF EXISTS `automation_process`;
CREATE TABLE `automation_process`  (
                                       `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                       `process_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '流程名称',
                                       `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程说明',
                                       `process_definition` json NOT NULL COMMENT '流程定义数据(直接把格式传给前端渲染)',
                                       `process_type` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '流程类型',
                                       `version` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '版本号',
                                       `process_constants` json NULL COMMENT '流程全局变量',
                                       `is_enable` int(1) NOT NULL COMMENT '是否可用；0停用，1启用',
                                       `status` int(1) NOT NULL COMMENT '流程状态：0已保存，1待审批，2审核通过，3驳回，4已发布，5历史流程',
                                       `source_process_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程拷贝时被拷贝的流程id',
                                       `create_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
                                       `create_user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人姓名',
                                       `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                       `update_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
                                       `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                       `approve_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '审核人',
                                       `approve_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
                                       `approve_process_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '审核流程ID',
                                       `change_or_clone` int(1) NULL DEFAULT NULL COMMENT '0变更，1克隆',
                                       `operation_group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作组id',
                                       `reject_information` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '驳回信息',
                                       `global_source` json NULL COMMENT '复用的全局变量',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_process
-- ----------------------------

-- ----------------------------
-- Table structure for automation_process_business_relation
-- ----------------------------
DROP TABLE IF EXISTS `automation_process_business_relation`;
CREATE TABLE `automation_process_business_relation`  (
                                                         `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                                         `process_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程id',
                                                         `business_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '业务id',
                                                         `business_type` int(2) NULL DEFAULT NULL COMMENT '业务类型：0是应用巡检，1是主机巡检',
                                                         `create_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
                                                         `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                                         `update_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
                                                         `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '流程和运维业务对应关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_process_business_relation
-- ----------------------------

-- ----------------------------
-- Table structure for automation_process_datasource_task
-- ----------------------------
DROP TABLE IF EXISTS `automation_process_datasource_task`;
CREATE TABLE `automation_process_datasource_task`  (
                                                       `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                                       `node_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节点ID',
                                                       `task_exec_log_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务执行ID',
                                                       `status` int(2) NULL DEFAULT NULL COMMENT '执行状态',
                                                       `start_time` datetime(0) NULL DEFAULT NULL,
                                                       `end_time` datetime(0) NULL DEFAULT NULL,
                                                       `create_time` datetime(0) NULL DEFAULT NULL,
                                                       `update_time` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_process_datasource_task
-- ----------------------------

-- ----------------------------
-- Table structure for automation_process_instance
-- ----------------------------
DROP TABLE IF EXISTS `automation_process_instance`;
CREATE TABLE `automation_process_instance`  (
                                                `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                                `process_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '流程id',
                                                `status` int(1) NOT NULL COMMENT '流程状态：执行失败0，执行成功1，执行中2，暂停3',
                                                `task_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务id',
                                                `task_history_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务执行记录id',
                                                `create_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '流程发起人',
                                                `create_time` datetime(0) NOT NULL COMMENT '发起时间',
                                                `process_content` json NULL COMMENT '流程实例上下文',
                                                `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                                `parent_task_history_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '父任务实例id',
                                                `parent_node_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '父流程的子流程id',
                                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_process_instance
-- ----------------------------

-- ----------------------------
-- Table structure for automation_process_multiplex_datasource
-- ----------------------------
DROP TABLE IF EXISTS `automation_process_multiplex_datasource`;
CREATE TABLE `automation_process_multiplex_datasource`  (
                                                            `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                                            `value` json NOT NULL COMMENT '值',
                                                            `task_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '作业id',
                                                            `create_time` datetime(0) NOT NULL COMMENT '创建时间',
                                                            `update_time` datetime(0) NOT NULL COMMENT '更新时间',
                                                            `flag` int(1) NOT NULL COMMENT '0：全局变量1：复用数据源',
                                                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_process_multiplex_datasource
-- ----------------------------

-- ----------------------------
-- Table structure for automation_process_node
-- ----------------------------
DROP TABLE IF EXISTS `automation_process_node`;
CREATE TABLE `automation_process_node`  (
                                            `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                            `node_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '前端节点id',
                                            `process_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '流程id，节点归属哪个流程',
                                            `node_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节点名称',
                                            `node_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节点类型：startNode：开始节点，endNode： 结束节点，link： 连线，rect： 执行节点，branch： 分支节点，parallel： 并行节点，convergence： 汇聚节点',
                                            `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节点说明',
                                            `exec_condition` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '执行的前置条件',
                                            `time_out` int(2) NULL DEFAULT NULL COMMENT '超时时间,单位是秒',
                                            `fail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '失败处理：0自动忽略；1手动跳过；2手动重试',
                                            `from_node_ids` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '前节点ids',
                                            `to_node_ids` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '后节点ids',
                                            `plugins_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '插件id',
                                            `input_params` json NULL COMMENT '插件入参',
                                            `output_params` json NULL COMMENT '插件出参',
                                            `datasource` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '数据源信息',
                                            `subprocess_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '子流程模板id',
                                            `exec_type` int(11) NULL DEFAULT NULL COMMENT '执行配置类型 0代表‘自动执行’，1代表‘定时执行’，2代表‘重复执行’',
                                            `exec_rule` json NULL COMMENT '执行配置规则 exec_type为1时，0代表‘T+0’，1代表‘T+1’',
                                            `exec_cron` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'cron表达式',
                                            `success_tag` int(2) NULL DEFAULT NULL COMMENT '成功标识：0代表全部成功，1代表部分成功',
                                            `wait_time` int(11) NULL DEFAULT NULL COMMENT '等待时间',
                                            `is_wait` int(2) NULL DEFAULT NULL COMMENT '是否等待：0代表‘否’，1代表‘是’',
                                            `plugins_data` json NULL COMMENT '插件内容',
                                            `front_node_data` json NULL COMMENT '前端节点内容',
                                            `status` int(1) NULL DEFAULT 1 COMMENT '节点状态：0停用，1启用',
                                            PRIMARY KEY (`id`) USING BTREE,
                                            INDEX `index_automation_process_node`(`node_id`, `process_id`, `node_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_process_node
-- ----------------------------

-- ----------------------------
-- Table structure for automation_process_node_instance
-- ----------------------------
DROP TABLE IF EXISTS `automation_process_node_instance`;
CREATE TABLE `automation_process_node_instance`  (
                                                     `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                                     `process_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程id',
                                                     `process_node_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程节点id',
                                                     `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程实例id',
                                                     `status` int(1) NULL DEFAULT NULL COMMENT '节点状态：0执行失败，1未开始执行，2执行中，3执行成功，4执行暂停',
                                                     `task_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务id',
                                                     `task_history_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务执行记录id',
                                                     `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                                     `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                                     `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
                                                     `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
                                                     `excute_result` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '执行结果',
                                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_process_node_instance
-- ----------------------------

-- ----------------------------
-- Table structure for automation_process_plugins
-- ----------------------------
DROP TABLE IF EXISTS `automation_process_plugins`;
CREATE TABLE `automation_process_plugins`  (
                                               `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                               `plugins_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                               `process_type_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
                                               `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT 'SQL脚本内容',
                                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_process_plugins
-- ----------------------------

-- ----------------------------
-- Table structure for automation_process_task
-- ----------------------------
DROP TABLE IF EXISTS `automation_process_task`;
CREATE TABLE `automation_process_task`  (
                                            `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                            `task_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务名称',
                                            `cron_express` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'cron表达式',
                                            `task_type` int(1) NULL DEFAULT NULL COMMENT '任务分类：0节点任务；1流程任务；2子流程任务',
                                            `process_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程id',
                                            `process_node_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '节点id',
                                            `is_enable` int(1) NULL DEFAULT NULL COMMENT '启动或者暂停：0停用；1启动',
                                            `excite_type` int(1) NULL DEFAULT NULL COMMENT '执行设置 0:手工执行 1:定时执行 2:计划执行',
                                            `approval_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '审批流程id',
                                            `select_cron` int(1) NULL DEFAULT NULL COMMENT '选择corn表达式：0选择，1是自定义',
                                            `plan_execute_time` datetime(0) NULL DEFAULT NULL COMMENT '计划执行时间',
                                            `trigger_last_time` bigint(13) NULL DEFAULT NULL COMMENT '上次调度时间',
                                            `trigger_next_time` bigint(13) NULL DEFAULT NULL COMMENT '下次调度时间',
                                            `status` int(1) NOT NULL COMMENT '流程状态：0草稿，1审核通过，2审核不通过，3已发布，4历史流程',
                                            `source_task_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程拷贝时被拷贝的流程id',
                                            `create_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
                                            `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                            `update_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
                                            `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                            `approve_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '审核人',
                                            `approve_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
                                            `is_clone` int(1) NULL DEFAULT NULL COMMENT '0变更，1克隆',
                                            `system_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '所属应用系统id',
                                            `group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '执行组',
                                            `process_constants` json NULL COMMENT '流程全局变量',
                                            `parent_task_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '父任务id',
                                            `operation_group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作组id',
                                            `reject_information` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '驳回信息',
                                            PRIMARY KEY (`id`) USING BTREE,
                                            INDEX `index_process_id`(`process_id`, `task_type`, `group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '任务' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_process_task
-- ----------------------------

-- ----------------------------
-- Table structure for automation_target_datasource
-- ----------------------------
DROP TABLE IF EXISTS `automation_target_datasource`;
CREATE TABLE `automation_target_datasource`  (
                                                 `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                                 `ip_address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '目标机ip',
                                                 `excute_status` int(1) NULL DEFAULT NULL COMMENT '执行状态',
                                                 `jumpserver_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '堡垒机id',
                                                 `jumpserver_ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '堡垒机ip',
                                                 `host_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '执行主机id',
                                                 `host_ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '执行主机ip',
                                                 `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                                 `create_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人id',
                                                 `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人name',
                                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '堡垒机接管服务表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_target_datasource
-- ----------------------------

-- ----------------------------
-- Table structure for automation_task_exec_history_log
-- ----------------------------
DROP TABLE IF EXISTS `automation_task_exec_history_log`;
CREATE TABLE `automation_task_exec_history_log`  (
                                                     `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
                                                     `task_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务id',
                                                     `task_history_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务执行历史id',
                                                     `parent_task_history_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父任务执行记录id（针对子流程）',
                                                     `node_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程节点id',
                                                     `node_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '流程节点实例id',
                                                     `status` int(1) NULL DEFAULT NULL COMMENT '执行状态：0失败，1成功',
                                                     `result` json NULL COMMENT '执行结果',
                                                     `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
                                                     `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
                                                     `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                                     `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '任务执行日志' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_task_exec_history_log
-- ----------------------------

-- ----------------------------
-- Table structure for automation_task_exec_log
-- ----------------------------
DROP TABLE IF EXISTS `automation_task_exec_log`;
CREATE TABLE `automation_task_exec_log`  (
                                             `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'id',
                                             `task_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务id',
                                             `task_history_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务执行历史id',
                                             `parent_task_history_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '父任务执行记录id（针对子流程）',
                                             `node_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程节点id',
                                             `node_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程节点实例id',
                                             `status` int(1) NULL DEFAULT NULL COMMENT '执行状态：0失败，1成功',
                                             `result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '执行结果',
                                             `worker_log_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT 'worker日志详情',
                                             `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
                                             `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
                                             `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                             `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                             PRIMARY KEY (`id`) USING BTREE,
                                             INDEX `index_automation_task_exec_log`(`node_id`, `task_history_id`, `parent_task_history_id`, `end_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '任务执行日志' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_task_exec_log
-- ----------------------------

-- ----------------------------
-- Table structure for automation_task_history
-- ----------------------------
DROP TABLE IF EXISTS `automation_task_history`;
CREATE TABLE `automation_task_history`  (
                                            `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                            `task_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '任务id',
                                            `status` int(2) NULL DEFAULT NULL COMMENT '执行状态：0失败，1成功，2执行中，3暂停',
                                            `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始执行时间',
                                            `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束执行时间',
                                            `input_params` json NULL COMMENT '入参',
                                            `output_params` json NULL COMMENT '出参',
                                            `remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '执行备注，记录错误信息',
                                            `exec_result` int(1) NULL DEFAULT NULL COMMENT '执行结果；0失败，1成功',
                                            `process_instance_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '流程实例id',
                                            `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                            `create_user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
                                            `create_user_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人名称',
                                            PRIMARY KEY (`id`) USING BTREE,
                                            INDEX `index_task_id`(`task_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_task_history
-- ----------------------------

-- ----------------------------
-- Table structure for automation_task_log_report
-- ----------------------------
DROP TABLE IF EXISTS `automation_task_log_report`;
CREATE TABLE `automation_task_log_report`  (
                                               `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                               `execute_day` datetime(0) NULL DEFAULT NULL COMMENT '调度日期',
                                               `running_count` int(11) NULL DEFAULT NULL COMMENT '运行中数量',
                                               `suc_count` int(11) NULL DEFAULT NULL COMMENT '执行成功数量',
                                               `fail_count` int(11) NULL DEFAULT NULL COMMENT '执行失败数量',
                                               `create_time` datetime(0) NULL DEFAULT NULL COMMENT '统计时间',
                                               `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
                                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_task_log_report
-- ----------------------------

-- ----------------------------
-- Table structure for automation_worker
-- ----------------------------
DROP TABLE IF EXISTS `automation_worker`;
CREATE TABLE `automation_worker`  (
                                      `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                      `worker_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'worker唯一id，贯穿全局',
                                      `worker_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'worker名称',
                                      `region` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'worker域',
                                      `register_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
                                      `worker_ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'workerIp',
                                      PRIMARY KEY (`id`) USING BTREE,
                                      UNIQUE INDEX `worker_id`(`worker_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_worker
-- ----------------------------

-- ----------------------------
-- Table structure for automation_worker_heart
-- ----------------------------
DROP TABLE IF EXISTS `automation_worker_heart`;
CREATE TABLE `automation_worker_heart`  (
                                            `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
                                            `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'worker名称',
                                            `ip` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'workerIp',
                                            `worker_status` int(2) NULL DEFAULT NULL COMMENT 'worker状态(1  UP:正常;0  DOWN:失败;2  OUTTIME:超时)',
                                            `worker_port` int(5) NULL DEFAULT NULL COMMENT 'worker端口',
                                            `worker_date` datetime(0) NULL DEFAULT NULL COMMENT '心跳时间',
                                            `thread_pool_max` int(11) NULL DEFAULT NULL COMMENT 'worker线程池最大线程',
                                            `thread_pool_active` int(11) NULL DEFAULT NULL COMMENT 'worker线程池活动线程',
                                            `thread_pool_residue` int(11) NULL DEFAULT NULL COMMENT 'worker线程池可用线程',
                                            `disk_space_status` int(2) NULL DEFAULT NULL COMMENT '磁盘状态(1  UP:正常;  0  DOWN:失败)',
                                            `disk_space_total` bigint(20) NULL DEFAULT NULL COMMENT '磁盘总空间 KB',
                                            `disk_space_free` bigint(20) NULL DEFAULT NULL COMMENT '磁盘剩余空间 KB',
                                            `disk_space_used` bigint(20) NULL DEFAULT NULL COMMENT '磁盘使用空间 KB',
                                            `rabbit_status` int(2) NULL DEFAULT NULL COMMENT 'rabbitMQ状态 (1  UP:正常;  0   DOWN:失败)',
                                            `rabbit_version` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'rabbitMQ版本',
                                            `monitor_num` int(11) NULL DEFAULT NULL COMMENT '检测次数',
                                            `timeout_num` int(11) NULL DEFAULT NULL COMMENT '超时次数',
                                            `worker_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'worker唯一ID,贯穿全局',
                                            PRIMARY KEY (`id`) USING BTREE,
                                            UNIQUE INDEX `worker_id_unique`(`worker_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of automation_worker_heart
-- ----------------------------

-- ----------------------------
-- Table structure for system_log
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log`  (
                               `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '日志表主键ID',
                               `user_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作用户ID',
                               `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作用户账号',
                               `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作用户名称',
                               `tenant_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作租户id',
                               `organization_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作用户所在机构部门',
                               `menu_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '系统操作模块',
                               `operation_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作ID',
                               `ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作主机IP',
                               `port` int(4) NULL DEFAULT NULL COMMENT '当前系统微服务端口',
                               `micro_service` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统请求微服务名称',
                               `class_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统请求微服务方法函数路径',
                               `class_param` json NULL COMMENT '当前系统请求微服务方法函数参数',
                               `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '日志类型（登录日志，操作日志，流程日志，脚本日志）',
                               `service_type` int(2) NULL DEFAULT NULL COMMENT '服务类型(0:客户端调用, 1:内部服务间调用)',
                               `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '当前系统操作说明',
                               `edit_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '操作时间',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统日志信息' ROW_FORMAT = DYNAMIC;

