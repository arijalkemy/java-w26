    package org.responseentity.manejoexcepciones1.entity;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.time.LocalDateTime;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class BlogEntity {
        private int id;
        private String title;
        private String author;
        private LocalDateTime publishDate;
    }
