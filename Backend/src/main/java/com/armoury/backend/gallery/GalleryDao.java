package com.armoury.backend.gallery;

import com.armoury.backend.gallery.model.PostInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class GalleryDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<PostInfo> getPostInfo(int pageNum) {
        String getQuery = "SELECT postIdx, userIdx, title FROM Post ORDER BY postTime DESC LIMIT ?, 5;";
        return this.jdbcTemplate.query(getQuery,
                (rs, rowNum) -> new PostInfo(
                        rs.getInt("postIdx"),
                        rs.getInt("userIdx"),
                        rs.getString("title")
                ), pageNum);
    }
}
