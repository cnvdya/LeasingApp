package sjsu.jentab.EaseYourLease.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import sjsu.jentab.EaseYourLease.model.SearchResult;
import sjsu.jentab.EaseYourLease.security.AWSCredentialsKeys;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchResultMapper  implements RowMapper<SearchResult> {

    @Override
    public SearchResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        SearchResult searchResult = new SearchResult();
        searchResult.setApartmentId(rs.getInt("apartmentId"));
        searchResult.setApartmentName(rs.getString("apartmentName"));
        searchResult.setAdressLine1(rs.getString("adressLine1"));
        searchResult.setAdressLine2(rs.getString("adressLine2"));
        searchResult.setCity(rs.getString("city"));
        searchResult.setState(rs.getString("state"));
        searchResult.setCountry(rs.getString("country"));
        searchResult.setCode(rs.getString("code"));
        searchResult.setFlatId(rs.getInt("flatId"));
        searchResult.setFlatName(rs.getString("flatName"));
        searchResult.setDetails(rs.getString("details"));
        searchResult.setType(rs.getString("type"));
        searchResult.setPrice(rs.getString("price"));
        searchResult.setAvailability(rs.getString("availability"));
        searchResult.setLabels(rs.getString("labels"));
        searchResult.setImagepath(AWSCredentialsKeys.S3_URL +rs.getString("imagePath"));


        return searchResult;
    }
}
