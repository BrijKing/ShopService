package com.example.shop_service.service_imp;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

public class CustomMultipart implements MultipartFile {
	
	private byte[] input;
	
	public CustomMultipart(byte[] input) {
		this.input = input;	
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	@Nullable
	public String getOriginalFilename() {
		return null;
	}

	@Override
	@Nullable
	public String getContentType() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		 return input == null || input.length == 0;
	}

	@Override
	public long getSize() {
		return input.length;
	}

	@Override
	public byte[] getBytes() throws IOException {
		return input;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(input);
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		try(FileOutputStream fos = new FileOutputStream(dest)) {
            fos.write(input);
        }	
	}
}