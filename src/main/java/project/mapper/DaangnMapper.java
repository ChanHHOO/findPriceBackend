package project.mapper;

import java.util.List;

import project.vo.DaangnVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DaangnMapper {
    List<DaangnVO> searchItemPrice();
    void insertDaangnSearcedDatas(
        String itemTitle, 
        String maxImgSrc,
        String minImgSrc,
        int avrItemPrice,
        int maxItemPrice,
        int minItemPrice);
}