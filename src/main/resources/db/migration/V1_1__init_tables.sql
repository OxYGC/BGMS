-- H2 数据库 数据类型不指定长度
CREATE TABLE `player_template` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`create_time` DATETIME ( 6 ) NOT NULL DEFAULT CURRENT_TIMESTAMP ( 6 ) COMMENT '创建时间',
	`modify_time` DATETIME ( 6 ) DEFAULT NULL COMMENT '修改时间',
	`version` INT NOT NULL DEFAULT '1',
	`deleted` TINYINT NOT NULL DEFAULT '0' COMMENT '是否删除： true 删除 false 未删除',
	`modifier_id` BIGINT DEFAULT NULL COMMENT '修改人ID, @link user.id',
	`modifier_username` VARCHAR ( 20 ) DEFAULT NULL COMMENT '修改人, @link user.username',
	`template_name` VARCHAR ( 30 ) NOT NULL COMMENT '模版名称',
	`enabled` TINYINT NOT NULL DEFAULT '0' COMMENT '是否启用：false 禁用 (默认) / true 启用 ',
	`device_type` TINYINT NOT NULL DEFAULT '0' COMMENT '终端类型： 1、H5  2、PC 3、APP',
	PRIMARY KEY ( `id` )
);