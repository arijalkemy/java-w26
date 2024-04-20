    package org.responseentity.linktracker.exceptions;

    import org.apache.coyote.BadRequestException;
    import org.responseentity.linktracker.dto.LinkDTO;
    import org.responseentity.linktracker.dto.LinkErrorDTO;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.ControllerAdvice;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.bind.annotation.RestController;

    @ControllerAdvice(annotations = RestController.class)
    public class LinkControlAdvice {

        @ExceptionHandler(value = CustomIllegalArgumentExeption.class)
        public ResponseEntity<LinkErrorDTO> illegalArgumentExceptionHandler(CustomIllegalArgumentExeption ex){
            LinkErrorDTO error = new LinkErrorDTO(ex.getMessage());
            return new ResponseEntity<>(
                    error,
                    HttpStatus.BAD_REQUEST
            );
        }

        @ExceptionHandler(value = NullPointerException.class)
        public ResponseEntity<LinkErrorDTO> nullPointerExceptionHandler(NullPointerException ex){
            LinkErrorDTO error = new LinkErrorDTO(ex.getMessage());
            return new ResponseEntity<>(
                    error,
                    HttpStatus.NOT_FOUND
            );
        }

        @ExceptionHandler(value = RequestException.class)
        public ResponseEntity<LinkErrorDTO> requestExceptionHandler(RequestException ex){
            return new ResponseEntity<>(
                    new LinkErrorDTO(ex.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
        }

        @ExceptionHandler(value = BadRequestException.class)
        public ResponseEntity<LinkErrorDTO> basRequestExceptionHandler(BadRequestException ex){
            LinkErrorDTO errorDTO = new LinkErrorDTO(ex.getMessage());
            return new ResponseEntity<>(
                    errorDTO,
                    HttpStatus.NOT_FOUND
            );
        }
    }
