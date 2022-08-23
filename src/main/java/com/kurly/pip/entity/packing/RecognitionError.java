package com.kurly.pip.entity.packing;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.kurly.pip.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecognitionError extends BaseEntity {

	@Column(columnDefinition = "varchar(255) not null")
	private String imageLink;

	public static RecognitionError from(String imageLink) {
		return new RecognitionError(imageLink);
	}

	private RecognitionError(String imageLink) {
		this.imageLink = imageLink;
	}
}
