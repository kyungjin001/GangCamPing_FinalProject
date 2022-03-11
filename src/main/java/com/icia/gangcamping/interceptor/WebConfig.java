package com.icia.gangcamping.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1) // 해당 인터셉터가 적용되는 순서(우선순위)
                .addPathPatterns("/**") // 해당 프로젝트의 모든 주소에 대해 인터셉터를 적용
                .excludePathPatterns("/", "/member/save", "/member/login2","/member/emailDp","/member/confirmPW","/member/{memberId}","/kakakologin","/logout","/member/logout","/mail/pwMailCheck","/mail/mailCode","/mail/codeCheck","resources/**","/**/*.css","/**/*.js","/images/**/*.*","/img/**/*.*","/styles/**/*.*","/plugins/**/*.*","/test","/insertCampingDB","/insertDetailDB","/css/**","/error/**");
         // 제외 할 주소(ex. 회원가입, 메인페이지 등)
    }
}
