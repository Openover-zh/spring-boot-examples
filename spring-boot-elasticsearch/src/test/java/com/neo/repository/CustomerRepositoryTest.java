package com.neo.repository;

import com.neo.model.Customer;
import com.neo.pojo.User;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.*;
import org.elasticsearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.filter.ParsedFilter;
import org.elasticsearch.search.aggregations.bucket.terms.*;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.ParsedMax;
import org.elasticsearch.search.aggregations.metrics.TopHitsAggregationBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Autowired
    private RestHighLevelClient restHighLevelClient;
//
    @Test
    public void saveCustomers() {
//        repository.save(new Customer("Alice", "北京","CT",13));
//        repository.save(new Customer("Bob", "北京","CT",55));
//        repository.save(new Customer("zhang1", "北京","QD",33));
//        repository.save(new Customer("neo", "西安","QD",30));
//        repository.save(new Customer("li", "济南","QD",50));
//        repository.save(new Customer("summer", "烟台","DEM",22));
        test("1","2","3");
    }

    @SafeVarargs
    public final <E> void test(E... va){
        System.out.println(Arrays.toString(Arrays.stream(va).toArray()));

    }
//
    @Test
    public void fetchAllCustomers() {
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        Iterable<Customer> iterable=repository.findAll();
        for (Customer customer :iterable) {
            System.out.println(customer);
        }

    }
//
//    @Test
//    public void deleteCustomers() {
//        repository.deleteAll();
////        repository.deleteByUserName("neo");
//    }
//
//    @Test
//    public void updateCustomers() {
//        Customer customer= repository.findByUserName("summer");
//        System.out.println(customer);
//        customer.setAddress("北京市海淀区西直门");
//        repository.save(customer);
//        Customer xcustomer=repository.findByUserName("summer");
//        System.out.println(xcustomer);
//    }
//
//    @Test
//    public void fetchIndividualCustomers() {
//        System.out.println("Customer found with findByUserName('summer'):");
//        System.out.println("--------------------------------");
//        System.out.println(repository.findByUserName("summer"));
//        System.out.println("--------------------------------");
//        System.out.println("Customers found with findByAddress(\"北京\"):");
//        String q="北京";
//        for (Customer customer : repository.findByAddress(q)) {
//            System.out.println(customer);
//        }
//    }
//
//    @Test
//    public void fetchPageCustomers() {
//        System.out.println("Customers found with fetchPageCustomers:");
//        System.out.println("-------------------------------");
//        Sort sort = new Sort(Sort.Direction.DESC, "address.keyword");
//        Pageable pageable = PageRequest.of(0, 10, sort);
//        Page<Customer> customers=repository.findByAddress("北京", pageable);
//        System.out.println("Page customers "+customers.getContent().toString());
//    }
//
    @Test
    public void fetchPage2Customers() {
        System.out.println("Customers found with fetchPageCustomers:");
        System.out.println("-------------------------------");
       QueryBuilder customerQuery = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("address", "北京"));
        Page<Customer> page = repository.search(customerQuery, PageRequest.of(0, 10));
        System.out.println("Page customers "+page.getContent().toString());
        page = repository.search(customerQuery, PageRequest.of(1, 10));
        System.out.println("Page customers "+page.getContent().toString()+"size:"+page.getNumber());
    }
//
    @Test
    public void fetchAggregation() {
        System.out.println("Customers found with fetchAggregation:");
        System.out.println("-------------------------------");
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.termQuery("address.keyword","北京"));
        FilterAggregationBuilder filter = AggregationBuilders.filter("filter", boolQueryBuilder);
        TermsAggregationBuilder sources = AggregationBuilders.terms("sources").field("source.keyword");
        MaxAggregationBuilder maxAggregationBuilder = AggregationBuilders.max("maxAge").field("age");
        sources.subAggregation(maxAggregationBuilder);
        filter.subAggregation(sources);
        nativeSearchQueryBuilder.addAggregation(filter);
        SearchHits<Customer> search = elasticsearchTemplate.search(nativeSearchQueryBuilder.build(), Customer.class, IndexCoordinates.of("customer"));
        Aggregations aggregations = search.getAggregations();
        ParsedFilter parsedFilter = aggregations.get("filter");
        ParsedStringTerms stringTerms = parsedFilter.getAggregations().get("sources");
        List<? extends Terms.Bucket> buckets = stringTerms.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            System.out.println("key:"+bucket.getKeyAsString());
            Aggregations avgAggs = bucket.getAggregations();
            ParsedMax maxAge = avgAggs.get("maxAge");
            System.out.println("maxAge:"+maxAge.getValueAsString()+" name:"+maxAge.getName());
        }
        System.out.println();
    }

}
