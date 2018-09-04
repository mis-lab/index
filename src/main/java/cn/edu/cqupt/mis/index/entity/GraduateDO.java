package cn.edu.cqupt.mis.index.entity;

/**
 * 映射 graduate 表
 * @author hanyuxiao
 */
public class GraduateDO {

    /**
     * 唯一 id
     */
    private int id;
    /**
     * 该同学的名字
     */
    private String name;
    /**
     * 该同学在工作室的学习方向
     */
    private String title;
    /**
     * 该同学毕业后去的公司的名称
     */
    private String jobName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
