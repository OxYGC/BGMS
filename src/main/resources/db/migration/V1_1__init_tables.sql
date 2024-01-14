
CREATE TABLE `player_template` (
	`id` BIGINT ( 20 ) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`create_time` DATETIME ( 6 ) NOT NULL DEFAULT CURRENT_TIMESTAMP ( 6 ) COMMENT '创建时间',
	`modify_time` DATETIME ( 6 ) DEFAULT NULL COMMENT '修改时间',
	`version` INT ( 11 ) NOT NULL DEFAULT '1' COMMENT '版本号',
	`deleted` TINYINT ( 1 ) NOT NULL DEFAULT '0' COMMENT '是否删除： true 删除 false 未删除',
	`modifier_id` BIGINT ( 20 ) UNSIGNED DEFAULT NULL COMMENT '修改人ID, @link user.id',
	`modifier_username` VARCHAR ( 20 ) DEFAULT NULL COMMENT '修改人, @link user.username',
	`template_name` VARCHAR ( 30 ) NOT NULL COMMENT '模版名称',
	`enabled` TINYINT ( 1 ) NOT NULL DEFAULT '0' COMMENT '是否启用：false 禁用 (默认) / true 启用 ',
	`device_type` TINYINT ( 2 ) NOT NULL DEFAULT '0' COMMENT '终端类型： 1、H5  2、PC 3、APP',
	`num` INT ( 1 ) DEFAULT '1' COMMENT '模板编号； 一般一套模板包含PC和H5两个，此两个模板对应的模板编号相同； 如：1   表示第1套模板',
PRIMARY KEY ( `id` )
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COMMENT = '玩家模版';



-- H2
CREATE TABLE `player_template` (
	`id` BIGINT  NOT NULL AUTO_INCREMENT,
	`create_time` DATETIME ( 6 ) NOT NULL DEFAULT CURRENT_TIMESTAMP ( 6 ),
	`modify_time` DATETIME ( 6 ) DEFAULT NULL ,
	`version` INT ( 11 ) NOT NULL DEFAULT '1',
	`deleted` TINYINT ( 1 ) NOT NULL DEFAULT '0' COMMENT '是否删除： true 删除 false 未删除',
	`modifier_id` BIGINT DEFAULT NULL COMMENT '修改人ID, @link user.id',
	`modifier_username` VARCHAR ( 20 ) DEFAULT NULL COMMENT '修改人, @link user.username',
	`template_name` VARCHAR ( 30 ) NOT NULL COMMENT '模版名称',
	`enabled` TINYINT ( 1 ) NOT NULL DEFAULT '0' COMMENT '是否启用：false 禁用 (默认) / true 启用 ',
	`device_type` TINYINT ( 2 ) NOT NULL DEFAULT '0' COMMENT '终端类型： 1、H5  2、PC 3、APP',
	`num` INT ( 1 ) DEFAULT '1' COMMENT '模板编号； 一般一套模板包含PC和H5两个，此两个模板对应的模板编号相同； 如：1   表示第1套模板',
PRIMARY KEY ( `id` ) );







CREATE TABLE player_template (
	id BIGINT  AUTO_INCREMENT ,
	modify_time DATETIME ( 6 ) DEFAULT NULL ,
	NAME VARCHAR ( 20 ) NOT NULL COMMENT '名字',
	Grade INT DEFAULT 1,
	PRIMARY KEY ( id )
);