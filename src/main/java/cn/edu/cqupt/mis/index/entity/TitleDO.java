package cn.edu.cqupt.mis.index.entity;

/**
 * 映射 title 数据表的实体对象
 * @author hanyuxiao
 */
public class TitleDO {
    /**
     * title 的唯一 id
     * 从 0 开始自增长
     */
    private int id;
    /**
     * title 的名称
     */
    private String titleName;
    /**
     * title 图标位置
     */
    private String pictureUrl;
    /**
     * 此 title 在我们工作室的主要工作
     */
    private String description;
    /**
     * 这个属性用来表示这一个发展方向在工作室是不是需要对外展示
     * true 表示需要对外展示，比如现在的 Java JavaScript
     * false 表示不展示，比如现在的测试运维工程师
     */
    private boolean canRead;

    public boolean isCanRead() {
        return canRead;
    }

    public void setCanRead(boolean canRead) {
        this.canRead = canRead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
