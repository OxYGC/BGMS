CREATE TABLE `b_user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(55) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '账号',
  `password` varchar(55) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `role` int(11) DEFAULT '0' COMMENT '角色：0-普通用户、1-管理员',
  `permission` varchar(155) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '权限：多个逗号分割',
  PRIMARY KEY (`id`) /*T![clustered_index] CLUSTERED */
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT ='用户表';;

-- 添加登陆账号（admin / 123456）
INSERT INTO `b_user` (`id`, `username`, `password`, `role`, `permission`) VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, '');

CREATE TABLE `saas_club`
(
    `id`                              bigint(24)                       NOT NULL COMMENT 'id',
    `brand_name`                      varchar(100) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '俱乐部品牌名称(对外)',
    `identifier_code`                 varchar(255) COLLATE utf8mb4_bin not null COMMENT '识别码（用于门店关联俱乐部）',
    `customer_name`                   varchar(255) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '客户名称',
    `brand_introduce`                 varchar(255) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '品牌介绍',
    `logo`                            varchar(255) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT 'logo地址',
    `club_type`                       tinyint(2)                                DEFAULT null COMMENT '俱乐部类型，1俱乐部 2工作室',
    `status`                          tinyint(1)                                DEFAULT '1' COMMENT '状态 1正常 0关闭',
    `bracelet_access_internet_status` tinyint(3)                       not null DEFAULT '1' COMMENT '手环是否需要入网，1是 0否',
    `create_time`                     datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`                     datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_user`                     varchar(255) COLLATE utf8mb4_bin          DEFAULT NULL COMMENT '创建者',
    PRIMARY KEY (`id`) USING BTREE,
    unique index `identifier_code_index` (`identifier_code`) using btree
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin
  ROW_FORMAT = DYNAMIC COMMENT ='俱乐部';


CREATE TABLE `saas_store`
(
    `id`                        bigint(20)   NOT NULL COMMENT '门店id',
    `club_id`                   bigint(20)   NOT NULL COMMENT '俱乐部id',
    `store_name`                varchar(100) NOT NULL COMMENT '门店品牌名称（对外展示名称），俱乐部下唯一',
    `brand_name`                varchar(100)          default NULL COMMENT '俱乐部名称',
    `create_time`               datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`               datetime              DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近更新时间',
    `create_user`               varchar(50)           default NULL COMMENT '创建人',
    `location_attribute`        int(5)       NOT NULL COMMENT '位置属性：1商业型、2写字楼型、3小区住宅型',
    `identifier_code`           varchar(150) NOT NULL COMMENT '门店识别码（为门店在平台的唯一代码）',
    `expire_time`               datetime              DEFAULT NULL COMMENT '过期时间-需求调整前的-废弃字段',
    `province_id`               bigint(20)            DEFAULT NULL COMMENT '省Id',
    `city_id`                   bigint(20)            DEFAULT NULL COMMENT '市id',
    `county_id`                 bigint(20)            DEFAULT NULL COMMENT '区id',
    `full_name`                 varchar(100)          DEFAULT NULL COMMENT '省市区全称',
    `address`                   varchar(255)          DEFAULT NULL COMMENT '详细地址',
    `latitude`                  decimal(10, 6)        DEFAULT NULL COMMENT '纬度',
    `longitude`                 decimal(10, 6)        DEFAULT NULL COMMENT '经度',
    `store_introduce`           text                  DEFAULT NULL COMMENT '门店介绍',
    `material_fill`             int(11)               DEFAULT '0' COMMENT '资料完善度  百分比 75%  为75',
    `run_status`                int(5)       NOT NULL DEFAULT '0' COMMENT '运营状态  0 试运营 1正式运营  2放价中',
    `advert_time`               datetime              DEFAULT NULL COMMENT '广告设备最近使用时间',
    `lead_name`                 varchar(20)           DEFAULT NULL COMMENT '负责人-需求调整前的-废弃字段',
    `lead_phone`                varchar(20)           DEFAULT NULL COMMENT '负责人电话-需求调整前的-废弃字段',
    `store_phone`               varchar(20)           DEFAULT NULL COMMENT '门店电话',
    `store_avatar`              varchar(255)          DEFAULT NULL COMMENT '门店头像（默认取门店对应图片库第一张）',
    `store_area`                int(10)               DEFAULT NULL COMMENT '门店面积',
    `not_entry_activate_device` int(3)                DEFAULT 0 COMMENT '未入场是否可以激活设备，1是,0否',
    `contract_code`             varchar(50)           DEFAULT NULL COMMENT '合同编号',
    `enable_status`             tinyint(1)            DEFAULT '1' COMMENT '启用状态,0:停用，1启用-需求调整前的-废弃字段',
    `holiday_start_time`        datetime              DEFAULT NULL COMMENT '放假开始时间',
    `holiday_end_time`          datetime              DEFAULT NULL COMMENT '放假截止时间',
    `deadline_start_time`       datetime              DEFAULT NULL COMMENT '期限开始时间',
    `deadline_end_time`         datetime              DEFAULT NULL COMMENT '期限截止时间',
    `shelf_status`              tinyint(1)            DEFAULT '1' COMMENT '上下架 0 下架 1上架-需求调整前的-废弃字段',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `ind_store_club_id` (`club_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='门店信息表';