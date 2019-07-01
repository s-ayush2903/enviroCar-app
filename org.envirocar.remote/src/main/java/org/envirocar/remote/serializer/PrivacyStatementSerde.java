package org.envirocar.remote.serializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.envirocar.core.entity.PrivacyStatement;
import org.envirocar.core.entity.PrivacyStatementImpl;

import java.lang.reflect.Type;

/**
 * @author dewall
 */
public class PrivacyStatementSerde implements JsonDeserializer<PrivacyStatement> {

    @Override
    public PrivacyStatement deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        // Get the values of the privacy statement.
        JsonObject termsOfUseObject = json.getAsJsonObject();
        String id = termsOfUseObject.get(PrivacyStatement.KEY_PRIVACY_STATEMENT_ID).getAsString();
        String issuedDate = termsOfUseObject.get(PrivacyStatement.KEY_PRIVACY_STATEMENT_ISSUEDATE).getAsString();

        // Get the optional content.
        String content = null;
        if (termsOfUseObject.has(PrivacyStatement.KEY_PRIVACY_STATEMENT_CONTENTS)) {
            content = termsOfUseObject.get(PrivacyStatement.KEY_PRIVACY_STATEMENT_CONTENTS).getAsString();
        }

        return new PrivacyStatementImpl(id, issuedDate, content);
    }
}