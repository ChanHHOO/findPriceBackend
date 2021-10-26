package project.mapper;

import java.util.List;

import project.vo.DaangnVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DaangnMapper {
    List<DaangnVO> searchItemPrice();
    List<DaangnVO> selectDaangnSearcedDatas(String itemTitle);
    void insertDaangnSearcedDatas(
        String itemTitle, 
        String maxArticleTitle,
        String minArticleTitle,
        String maxImgSrc,
        String minImgSrc,
        int avrItemPrice,
        int maxItemPrice,
        int minItemPrice,
        int articleCount,
        String chartDomain_firstX,
        String chartDomain_secondX,
        String chartDomain_thirdX,
        String chartDomain_fourthX,
        Integer chartData_firstY,
        Integer chartData_secondY,
        Integer chartData_thirdY,
        Integer chartData_fourthY);
}