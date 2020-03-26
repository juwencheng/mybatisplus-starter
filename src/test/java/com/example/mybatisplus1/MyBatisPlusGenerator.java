package com.example.mybatisplus1;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author juwencheng
 */
public class MyBatisPlusGenerator {

    public static void printHeader() {
        System.out.println("####################################################");
        System.out.println("###欢迎使用MyBatis-Plus代码生成工具");
        System.out.println("###将此工具放到parent工程下的测试用例中运行");
        System.out.println("###⚠️⚠️⚠️⚠️生成文件会自动覆盖之前文件，请谨慎操作⚠️⚠️⚠️⚠️");
        System.out.println("####################################################");
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        printHeader();
        String moduleName = scanner("模块名，p表示父工程，subModule为具体的子模块名");

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 获取工程所在目录
        String projectPath = System.getProperty("user.dir");
        if (moduleName.equals("p")) {
            globalConfig.setOutputDir(projectPath + "/src/main/java");
        } else {
            globalConfig.setOutputDir(projectPath + "/" + moduleName + "/src/main/java");
        }
        globalConfig.setAuthor("juwencheng");
        // 是否打开输出目录
        globalConfig.setOpen(false);
        // 是否重写文件
        globalConfig.setFileOverride(true);
        // 是否在xml中添加二级缓存配置
        globalConfig.setEnableCache(false);
        // 实体属性 Swagger2 注解，不一定是实体类直接返回给用户，自动生成可以供其他地方使用
//        globalConfig.setSwagger2(true);
        // 是否开启baseResultMap，测试是什么意思
        globalConfig.setBaseResultMap(true);
        // 是否开启baseColumnList
//        globalConfig.setBaseColumnList(true);
        // 时间类型
        globalConfig.setDateType(DateType.TIME_PACK);
        // ================= 自定义命名方式==================
        // 以下均为默认的命名
        globalConfig.setEntityName("%sEntity");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        autoGenerator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:8889/broker_message?useUnicode=true&useSSL=false" +
                "&characterEncoding=utf8" +
                "&serverTimezone=Asia/Shanghai");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        autoGenerator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        // 设置父类包名
        String packageName = scanner("包名");
        packageConfig.setParent(packageName);
        packageConfig.setMapper("dao.mapper");
        packageConfig.setEntity("dao.entity");
        packageConfig.setXml("dao.mapper.xml");
        // 设置模块名
        packageConfig.setModuleName(scanner("业务模块名"));

        autoGenerator.setPackageInfo(packageConfig);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig() {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                if (!moduleName.equals("p")) {
//
//                }else {
//
//                }
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
        cfg.setFileOutConfigList(focList);
        autoGenerator.setCfg(cfg);


        // 数据库表配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        /**
         * 设置公共的父类controller
         * strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
         * 也可设置公共的父类Service，ServiceImpl等
         */
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));

        // 是否生成实体时，生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(packageConfig.getModuleName() + "_");
        // 设置逻辑删除字段名
        strategy.setLogicDeleteFieldName("is_delete");
        // 设置乐观锁字段名
        strategy.setVersionFieldName("version");
        autoGenerator.setStrategy(strategy);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // 通过设置null来排除不需要自动生成的层
        String[] excludeModules =
                scanner("选择要生成的子模块，逗号分隔，可选值有\n  [0]. 全部\n  [1]. controller\n  [2]. service\n  [3]. impl\n  [4]. " +
                        "mapper\n  [5]. " +
                        "mapper.xml\n  [6]. entity\n").split(
                        ",");
        Boolean all = false;
        for (String module : excludeModules) {
            if ("0".equals(module)) {
                all = true;
                break;
            }
        }
        if (!all) {
            templateConfig.setXml(null);
            templateConfig.setMapper(null);
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
            templateConfig.setController(null);
            templateConfig.setEntity(null);
            for (String module : excludeModules) {
                switch (module.toLowerCase()) {
                    case "1":
                        templateConfig.setController(ConstVal.TEMPLATE_CONTROLLER);
                        break;
                    case "2":
                        templateConfig.setService(ConstVal.TEMPLATE_SERVICE);
                        break;
                    case "3":
                        templateConfig.setServiceImpl(ConstVal.TEMPLATE_SERVICE_IMPL);
                        break;
                    case "4":
                        templateConfig.setMapper(ConstVal.TEMPLATE_MAPPER);
                        break;
                    case "5":
                        templateConfig.setXml(ConstVal.TEMPLATE_XML);
                        break;
                    case "6":
                        templateConfig.setEntity(ConstVal.TEMPLATE_ENTITY_JAVA);
                        break;
                }
            }
        }
        autoGenerator.setTemplate(templateConfig);
        autoGenerator.execute();
    }
}
