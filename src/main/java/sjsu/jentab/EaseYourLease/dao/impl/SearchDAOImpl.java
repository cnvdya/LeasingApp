package sjsu.jentab.EaseYourLease.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import sjsu.jentab.EaseYourLease.model.Filter;
import sjsu.jentab.EaseYourLease.model.ImageLabels;
import sjsu.jentab.EaseYourLease.model.SearchResult;
import sjsu.jentab.EaseYourLease.security.AWSCredentialsKeys;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SearchDAOImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SearchResult getFlatDetails(int flatid){
        String sqlquery="select a1.id AS apartmentId, a1.apartmentName,a1.adressLine1,a1.adressLine2,a1.city,a1.state,a1.country,a1.code,f1.id AS flatId, f1.flatName, f1.type,f1.price,f1.availability from Flat f1, Apartment a1 where f1.id= ?";
        return jdbcTemplate.queryForObject(sqlquery, new Object[] {flatid}, new SearchResultMapper());

    }


    public List<SearchResult> getFiles (Filter filter) {

        System.out.println("Stating .... ");

        String sql = "select  a1.id AS apartmentId, a1.apartmentName,a1.adressLine1,a1.adressLine2,a1.city,a1.state,a1.country,a1.code,f1.id AS flatId, f1.flatName," +
                "f1.type,f1.price,f1.availability,i1.imageName AS imagePath ,\n" +
                "group_concat(i1.labels Separator ', ') AS labels,f1.details "+
                "    from\n" +
                "    Flat f1, Apartment a1,ImageLabels i1\n" +
                "    where\n" +
                "    f1.id=i1.flatId and\n" +
                "    f1.apartmentId = a1.id and\n" +
                "    f1.id in\n" +
                "            (select f.id from Flat f, Apartment a, ImageLabels i where\n" +
                "                    f.id = i.flatID and\n" +
                "                    f.apartmentId=a.id \n" ;

        StringBuilder query = new StringBuilder();
        query.append(sql);

        if(StringUtils.isNotEmpty(filter.getAmenity())){
            query.append(" and (i.labels like '%"+filter.getAmenity()+"%' || f.details like '%"+filter.getAmenity()+"%')");

        }
        if(StringUtils.isNotEmpty(filter.getPrice())){
            query.append(" and f.price >= "+ String.valueOf(Integer.parseInt(filter.getPrice())-500)+" && f.price <= "+String.valueOf(Integer.parseInt(filter.getPrice())+500));

        }
        if(StringUtils.isNotEmpty(filter.getType())){
            query.append(" and f.type = '"+filter.getType()+"'");
        }
        if(StringUtils.isNotEmpty(filter.getName())){
            query.append(" and a.apartmentName like '%"+filter.getName()+"%'");
        }
        query.append(") ");
        query.append("group by f1.id");

        System.out.println("final query "+query);

        List<SearchResult> searchResults = (List<SearchResult>)jdbcTemplate.query(query.toString(),new SearchResultMapper());



       // List<SearchResult> searchResults = jdbcTemplate.query(sql, new SearchResultMapper());
        //System.out.println(ls);
        for (SearchResult searchResult : searchResults){
            System.out.println(searchResult.getApartmentName()+ " "+ searchResult.getFlatName()+ " " + searchResult.getLabels()+ " "+ searchResult.getDetails() + " "+ searchResult.getImagepath());
        }
        return searchResults;
    }

    public SearchResult getdetails (int id) {

        System.out.println("Stating .... ");

        String sql = "select  a1.id AS apartmentId, a1.apartmentName,a1.adressLine1,a1.adressLine2,a1.city,a1.state,a1.country,a1.code,f1.id AS flatId, f1.flatName," +
                "f1.type,f1.price,f1.availability,i1.imageName AS imagePath ,\n" +
                "group_concat(i1.labels Separator ', ') AS labels,f1.details "+
                "    from\n" +
                "    Flat f1, Apartment a1,ImageLabels i1\n" +
                "    where\n" +
                "    f1.id=i1.flatId and\n" +
                "    f1.apartmentId = a1.id and\n" +
                "    f1.id in\n" +
                "            (select f.id from Flat f, Apartment a, ImageLabels i where\n" +
                "                    f.id = i.flatID and\n" +
                "                    f.apartmentId=a.id) \n" +
                "and f1.id = "+id+" group by f1.id";

        StringBuilder query = new StringBuilder();
        query.append(sql);


        System.out.println("final query "+query);
//        jdbcTemplate.queryForObject(sqlquery, new Object[] {flatid}, new SearchResultMapper());

        SearchResult searchResults = (SearchResult)jdbcTemplate.queryForObject(query.toString(),new SearchResultMapper());

        return searchResults;
    }

}
