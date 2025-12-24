package br.com.gabrielrot.serialization.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public final class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {


    protected YamlJackson2HttpMessageConverter() {
        super(new YAMLMapper());
    }
}
