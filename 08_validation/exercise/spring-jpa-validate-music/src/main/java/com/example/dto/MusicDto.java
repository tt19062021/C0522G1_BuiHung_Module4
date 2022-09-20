package com.example.dto;

import javax.validation.constraints.*;

public class MusicDto {

    private int id;

    @NotNull(message = "Không được phép để trống")
    @Size(min = 3,max = 800,message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String musicName;

    @NotBlank(message = "Không được phép để trống")
    @Size(min = 3,max = 255,message = "Không vượt quá 255 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String artist;

    @NotEmpty(message = "Không được phép để trống")
    @Size(min = 3,max = 1000,message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9, ]*$",message = "Trừ dấu phẩy “,” , các ký tự đặc biệt còn lại không được phép lưu vào DB.")
    private String kindOfMusic;

    public MusicDto() {
    }

    public MusicDto(int id, String musicName, String artist, String kindOfMusic) {
        this.id = id;
        this.musicName = musicName;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
