package org.example.api;

import org.example.api.response.Response;

public interface IDCCService {

    Response<Boolean> updateConfig(String key, String value);
}
