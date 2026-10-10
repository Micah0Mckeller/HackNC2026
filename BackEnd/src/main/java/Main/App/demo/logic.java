package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class logic {
     private static final String TEST_DESCRIPTION = "This is a test project";
    private final ProjectBoard Test = new ProjectBoard("Test Project", "AdminUser", TEST_DESCRIPTION);
    
    public ProjectBoard getTestProject() {
        return Test;
    }
   @GetMapping("/api/mix")
    public ProjectBoard getProject() {
    return Test;
}

    
}

