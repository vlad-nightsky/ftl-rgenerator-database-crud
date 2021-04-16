package {{meta.package}}.infrastructure.database.mongo.{{meta.nameLow}}.port;

import com.rcore.database.mongo.commons.utils.CollectionNameUtils;
import com.rcore.domain.commons.port.dto.SearchResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import {{meta.package}}.infrastructure.database.mongo.{{meta.nameLow}}.query.FindWithFiltersQuery;
import {{meta.package}}.infrastructure.database.mongo.{{meta.nameLow}}.documents.{{meta.nameUp}}Doc;
import {{meta.package}}.domain.{{meta.nameLow}}.entity.{{meta.nameUp}}Entity;
import {{meta.package}}.domain.{{meta.nameLow}}.port.{{meta.nameUp}}Repository;
import {{meta.package}}.domain.{{meta.nameLow}}.port.filters.{{meta.nameUp}}Filters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class Mongo{{meta.nameUp}}Repository implements {{meta.nameUp}}Repository {

    private final MongoTemplate mongoTemplate;

    @Override
    public {{meta.nameUp}}Entity save({{meta.nameUp}}Entity entity) {
        mongoTemplate.save(entity, CollectionNameUtils.getCollectionName({{meta.nameUp}}Doc.class));
        return entity;
    }

    @Override
    public Boolean delete(String s) {
        long deleteCount = mongoTemplate.remove(Query.query(Criteria.where("_id").is(s)), CollectionNameUtils.getCollectionName({{meta.nameUp}}Doc.class)).getDeletedCount();
        return deleteCount > 0;
    }

    @Override
    public Optional<{{meta.nameUp}}Entity> findById(String s) {
        return Optional.ofNullable(mongoTemplate.findById(s, {{meta.nameUp}}Doc.class));
    }

    @Override
    public SearchResult<{{meta.nameUp}}Entity> find({{meta.nameUp}}Filters filters) {
        Query query = new FindWithFiltersQuery(filters).getQuery();
        return SearchResult.withItemsAndCount(
                new ArrayList<>(mongoTemplate.find(query, {{meta.nameUp}}Doc.class)),
                mongoTemplate.count(query.limit(0).skip(0), {{meta.nameUp}}Doc.class)
        );
    }

    @Override
    public Long count() {
        return mongoTemplate.count(new Query(), {{meta.nameUp}}Doc.class);
    }
}
