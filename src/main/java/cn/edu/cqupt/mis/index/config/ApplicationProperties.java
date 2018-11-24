package cn.edu.cqupt.mis.index.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 应用的配置数据
 */
public class ApplicationProperties {

    private Logger logger = LoggerFactory.getLogger(ApplicationProperties.class);

    /**
     * 应用级别的元数据
     */
    private final String mainProfileName = "/application.properties";
    private final String springProfilesActiveMetadata = "spring.profiles.active";
    /**
     * 实际生效的配置文件
     */
    private String springProfilesActive;
    private String profileName = "";

    /**
     * 以下是框架级别的配置元数据
     */
    private final String mybatisMapperDirectoryNameMetadata = "mybatis.mappers.location";

    /**
     * mybatis 框架的配置数据
     */
    Resource[] mybatisMapperResources;

    /**
     * 工具级别的元数据
     * 以下是 mysql 配置的元数据
     */
    private final String mysqlUserNameMetadata = "mysql.username";
    private final String mysqlPasswordMetadata = "mysql.password";
    private final String mysqlHostMetadata = "mysql.host";
    private final String mysqlPortMetaData = "mysql.port";
    private final String mysqlDatabaseNameMetadata = "mysql.database.name";

    /**
     * 以下是读取到的 mysql 的配置
     */
    String mysqlUsername;
    String mysqlPassword;
    String mysqlHost;
    String mysqlPort;
    String mysqlDatabaseName;

    /**
     * 构造方法，在构造方法当中初始化整个项目的所有配置信息
     */
    ApplicationProperties() {
        initProperties();
    }

    /**
     * 初始化配置信息的入口，这个方法当中的初始化顺序很关键，不能随意的改动
     * 初始化的顺序大致为 应用级别的元数据 > 框架级别元数据 > 工具级别元数据
     */
    private void initProperties () {
        initApplicationProperties();
        initFrameworkProperties();
        initToolsProperties();
    }

    /**
     * 初始化应用级别的配置信息
     */
    private void initApplicationProperties () {
        try (InputStream inputStream = ApplicationProperties.class.getResourceAsStream(mainProfileName)) {
            ApplicationProperties.class.getResourceAsStream(mainProfileName);
            Properties properties = new Properties();
            properties.load(inputStream);
            springProfilesActive = properties.getProperty(springProfilesActiveMetadata, null);
            if (Objects.isNull(springProfilesActive) || springProfilesActive.isEmpty() || Objects.equals(0, springProfilesActive.length())) {
                profileName = mainProfileName;
            }
            else {
                profileName = "/application-" + profileName + ".properties";
            }

            if (Objects.isNull(ApplicationProperties.class.getResourceAsStream(profileName))) {
                logger.warn("配置文件{}没有找到，自动切换到{}", profileName, mainProfileName);
                profileName = mainProfileName;
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * 初始化项目集成的各类框架的数据
     */
    private void initFrameworkProperties () {
        initSpringBootProperties();
        initMybatisProperties();
    }

    /**
     * 初始化 Springboot 框架的数据
     */
    private void initSpringBootProperties () {
        // done nothing 因为没有东西可以来做
    }

    /**
     * 初始化 mybatis 框架的数据
     */
    private void initMybatisProperties () {
        try (InputStream inputStream = ApplicationProperties.class.getResourceAsStream(profileName)) {
            Properties properties = new Properties();
            properties.load(inputStream);

            String mybatisMapperDirectoryName = properties.getProperty(mybatisMapperDirectoryNameMetadata);
            if (Objects.isNull(ApplicationProperties.class.getResource(mybatisMapperDirectoryName))) {
                logger.error("mybatis 配置的 {} 产生空指针，请检查，可能会导致错误", mybatisMapperDirectoryNameMetadata);
                return;
            }
            File mybatisMapperDirectory = new File(ApplicationProperties.class.getResource(mybatisMapperDirectoryName).getFile());

            Stack<File> directoryStack = new Stack<>();
            List<File> mappers = new LinkedList<>();
            directoryStack.push(mybatisMapperDirectory);
            while (!directoryStack.empty()) {
                File directory = directoryStack.pop();
                File[] files = directory.listFiles();
                for (int i = 0; i < files.length; i++) {
                    File file = files[i];
                    if (file.isDirectory()) {
                        directoryStack.push(file);
                        break;
                    }
                    mappers.add(file);
                }
            }

            mybatisMapperResources = new Resource[mappers.size()];
            for (int i = 0; i < mappers.size(); i++) {
                mybatisMapperResources[i] = new FileSystemResource(mappers.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化各类工具的数据
     */
    private void initToolsProperties () {
        initMysqlProperties();
    }

    /**
     * 初始化 mysql 的数据
     */
    private void initMysqlProperties () {
        try (InputStream inputStream = ApplicationProperties.class.getResourceAsStream(profileName)) {
            Properties properties = new Properties();
            properties.load(inputStream);

            mysqlDatabaseName = properties.getProperty(mysqlDatabaseNameMetadata);
            mysqlUsername = properties.getProperty(mysqlUserNameMetadata);
            mysqlPassword = properties.getProperty(mysqlPasswordMetadata);
            mysqlHost = properties.getProperty(mysqlHostMetadata);
            mysqlPort = properties.getProperty(mysqlPortMetaData);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

}
