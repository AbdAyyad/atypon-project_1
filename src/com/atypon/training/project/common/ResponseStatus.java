package com.atypon.training.project.common;

import java.io.Serializable;

public enum ResponseStatus implements Serializable {
    Success, UnAuthorized, ServerError, NotFound
}
