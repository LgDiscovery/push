<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.benqio.push.common.dao.${tableClass.shortClassName}Dao">

    <resultMap id="${tableClass.shortClassName}ResultMap"
               type="com.benqio.push.common.model.${tableClass.shortClassName}">
<#if tableClass.pkFields??>
    <#list tableClass.pkFields as field>
        <id property="${field.fieldName}" jdbcType="${field.jdbcType}" column="${field.columnName}"/>
    </#list>
</#if>
<#if tableClass.baseFields??>
    <#list tableClass.baseFields as field>
        <result property="${field.fieldName}" jdbcType="${field.jdbcType}" column="${field.columnName}"/>
    </#list>
</#if>
    </resultMap>

    <resultMap id="${tableClass.shortClassName}ListItemResultMap"
               type="com.benqio.push.common.vo.${tableClass.shortClassName?lower_case}.${tableClass.shortClassName}ListItem"
               extends="${tableClass.shortClassName}ResultMap">
    </resultMap>

    <sql id="BaseList">
<#if tableClass.allFields??>
    <#list tableClass.allFields as field>
        <#if field_has_next>`${field.columnName}`, <#else>`${field.columnName}`</#if>
    </#list>
</#if>
    </sql>

    <!-- 分页查询${tableClass.introspectedTable.fullyQualifiedTable.remark}记录列表 -->
    <select id="query" resultMap="${tableClass.shortClassName}ListItemResultMap">
        SELECT
        <include refid="BaseList" />
        FROM ${tableClass.tableName}
        <trim prefix="WHERE" suffixOverrides="AND">
    <#list tableClass.allFields as field>
        <#if field.stringColumn>
            <if test="${field.fieldName}!=null and ${field.fieldName}!=''">`${field.columnName}`=${r"#{"}${field.fieldName}} AND </if>
        <#else>
            <if test="${field.fieldName}!=null">`${field.columnName}`=${r"#{"}${field.fieldName}} AND </if>
        </#if>
    </#list>
        </trim>
        <!--ORDER BY update_time DESC-->
    </select>

    <!-- 根据主键查询${tableClass.introspectedTable.fullyQualifiedTable.remark}记录详情 -->
    <select id="selectById" resultMap="${tableClass.shortClassName}ResultMap">
        SELECT
        <include refid="BaseList" />
        FROM ${tableClass.tableName}
        <trim prefix="WHERE" suffixOverrides="AND">
    <#list tableClass.pkFields as field>
        <#if field.stringColumn>
            <if test="${field.fieldName}!=null and ${field.fieldName}!=''">`${field.columnName}`=${r"#{"}${field.fieldName}} AND </if>
        <#else>
            <if test="${field.fieldName}!=null">`${field.columnName}`=${r"#{"}${field.fieldName}} AND </if>
        </#if>
    </#list>
        </trim>
    </select>

    <!-- 添加${tableClass.introspectedTable.fullyQualifiedTable.remark}新纪录 -->
    <insert id="insert" parameterType="com.benqio.push.common.model.${tableClass.shortClassName}" useGeneratedKeys="true" keyProperty="id" >
        INSERT INTO ${tableClass.tableName} (
        <#list tableClass.baseFields as field>
            <#if field_has_next>`${field.columnName}`, <#else>`${field.columnName}`</#if>
        </#list>
        )
        VALUES (
        <#list tableClass.baseFields as field>
            <#if field_has_next>${r"#{"}${field.fieldName}}, <#else>${r"#{"}${field.fieldName}}</#if>
        </#list>
        )
    </insert>

    <!-- 更新${tableClass.introspectedTable.fullyQualifiedTable.remark}记录 -->
    <update id="update" parameterType="com.benqio.push.common.model.${tableClass.shortClassName}">
        UPDATE ${tableClass.tableName}
        <set>
    <#list tableClass.baseFields as field>
        <#if field.stringColumn>
            <if test="${field.fieldName}!=null and ${field.fieldName}!=''">`${field.columnName}`=${r"#{"}${field.fieldName}}, </if>
        <#else>
            <if test="${field.fieldName}!=null">`${field.columnName}`=${r"#{"}${field.fieldName}}, </if>
        </#if>
    </#list>
        </set>
        <trim prefix="WHERE" suffixOverrides="AND">
    <#list tableClass.pkFields as field>
        <#if field.stringColumn>
            <if test="${field.fieldName}!=null and ${field.fieldName}!=''">`${field.columnName}`=${r"#{"}${field.fieldName}} AND </if>
        <#else>
            <if test="${field.fieldName}!=null">`${field.columnName}`=${r"#{"}${field.fieldName}} AND </if>
        </#if>
    </#list>
        </trim>
    </update>

    <!-- 根据主键删除${tableClass.introspectedTable.fullyQualifiedTable.remark}记录 -->
    <delete id="deleteById" >
        DELETE FROM ${tableClass.tableName}
        <trim prefix="WHERE" suffixOverrides="AND">
    <#list tableClass.pkFields as field>
        <#if field.stringColumn>
            <if test="${field.fieldName}!=null and ${field.fieldName}!=''">`${field.columnName}`=${r"#{"}${field.fieldName}} AND </if>
        <#else>
            <if test="${field.fieldName}!=null">`${field.columnName}`=${r"#{"}${field.fieldName}} AND </if>
        </#if>
    </#list>
        </trim>
    </delete>

</mapper>
