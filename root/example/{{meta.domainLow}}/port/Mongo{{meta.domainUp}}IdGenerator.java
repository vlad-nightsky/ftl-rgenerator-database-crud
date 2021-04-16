package {{meta.package}}.infrastructure.database.mongo.{{meta.nameLow}}.port;

import com.rcore.database.mongo.commons.port.impl.ObjectIdGenerator;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import {{meta.package}}.domain.{{meta.nameLow}}.port.{{meta.nameUp}}IdGenerator;

@Component
public class Mongo{{meta.nameUp}}IdGenerator extends ObjectIdGenerator implements {{meta.nameUp}}IdGenerator<ObjectId> {
}
