package com.sdzy;

import com.asdzy.common.mybatisplus.GeneratorServiceEntity;

public class GeneratorCode extends GeneratorServiceEntity{
	 
	 
	public static void main(String[] args) {
		//模块名称
		moduleName = "stock";
		//数据库表前缀
		tablePrefix = "";
		//文件存放路径
		outputDir = "src\\main\\java\\";
		//一次可以生成同一个模块下的所有表
		tableNames=new String[]{"stockTakingLog"};
		//自动注入字段
		fillFields=new String[]{"createDate","modifyDate"};
		//文件作者
		author = "charlin";
		//启用缓存
		enableCache=false;
		GeneratorCode.generateByTables();
	}
}
