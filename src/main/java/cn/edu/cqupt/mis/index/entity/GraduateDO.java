package cn.edu.cqupt.mis.index.entity;

/**
 * 映射 graduate 表
 * @author hanyuxiao
 */
public class GraduateDO {

    /**
     * 唯一 id
     * id 会从 0 开始自动增长
     */
    private int id;
    /**
     * 该同学的名字
     */
    private String name;
    /**
     * 该同学在工作室的学习方向
     * Java JavaScript PM
     */
    private String title;
    /**
     * 外键，映射到 title 数据表当中的 title.id
     */
    private int titleId;
    /**
     * 该同学毕业后去的公司的名称
     */
    private String jobName;
    /**
     * 学号，是一个字符串，因为可能有的学长的学号是 S 开头的
     */
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

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
