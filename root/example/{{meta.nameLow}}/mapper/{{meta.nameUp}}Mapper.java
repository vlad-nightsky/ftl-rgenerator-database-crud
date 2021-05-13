package {{meta.package}}.infrastructure.database.mongo.{{meta.nameLow}}.mapper;

import com.rcore.commons.mapper.ExampleDataMapper;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import {{meta.package}}.domain.{{meta.nameLow}}.entity.{{meta.nameUp}}Entity;
import {{meta.package}}.domain.{{meta.nameLow}}.port.{{meta.nameUp}}IdGenerator;
import {{meta.package}}.infrastructure.database.mongo.{{meta.nameLow}}.documents.{{meta.nameUp}}Doc;

@Component
@RequiredArgsConstructor
public class {{meta.nameUp}}Mapper implements ExampleDataMapper<{{meta.nameUp}}Entity, {{meta.nameUp}}Doc> {
    private final {{meta.nameUp}}IdGenerator<ObjectId> idGenerator;

    @Override
    public {{meta.nameUp}}Doc map({{meta.nameUp}}Entity entity) {
        return {{meta.nameUp}}Doc
                .builder()
                .id(idGenerator.parse(entity.getId()))
                {{#document.fields}}
                .{{name}}(entity.get{{nameUperCase}}())
                {{/document.fields}}
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    @Override
    public {{meta.nameUp}}Entity inverseMap({{meta.nameUp}}Doc doc) {
        return {{meta.nameUp}}Entity
                .builder()
                .id(doc.getId().toString())
                {{#document.fields}}
                .{{name}}(doc.get{{nameUperCase}}())
                {{/document.fields}}
                .createdAt(doc.getCreatedAt())
                .updatedAt(doc.getUpdatedAt())
                .build();
    }
}
