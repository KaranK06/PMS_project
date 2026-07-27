package com.example.pms.Business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class InfoUpdate {
    @Autowired
    ApplicationService applicationService;

    public String companyName;
    public String studentName;
    public String applicationStatus;
    public String jobRole;
}
