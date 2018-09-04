package cn.edu.cqupt.mis.index.entity;

/**
 * 映射 title 数据表的实体对象
 * @author hanyuxiao
 */
public class TitleDO {

    /**
     * title 的唯一 id
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
     * title 的描述
     */
    private String description;

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
