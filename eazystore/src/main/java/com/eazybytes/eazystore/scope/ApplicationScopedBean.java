package com.eazybytes.eazystore.scope;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;


@Component
@ApplicationScope @Getter
@Slf4j
public class ApplicationScopedBean {
    private int visitorsCount;

    public void incVisitorCount() {
        visitorsCount++;
    }
    public ApplicationScopedBean() {
        log.info("application scoped bin initialized");
    }

}
