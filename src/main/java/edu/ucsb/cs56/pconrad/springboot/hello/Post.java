package edu.ucsb.cs56.pconrad.springboot.hello;

import lombok.Data;
import lombok.RequiredArgsConstructor; // generates constructor for fields marked with @NonNull
import lombok.NoArgsConstructor;  // @NonNull property ignored by this constructor
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Post {

    @Id private String id;
    @NonNull private String title;
    @NonNull private String description;
	@NonNull private String email;
	@NonNull private String phone;
	@NonNull private String approved;
}
