package com.example.agentapp.auth.controller;

import com.example.agentapp.auth.dto.ChangePasswordRequest;
import com.example.agentapp.auth.dto.UserDTO;
import com.example.agentapp.auth.security.UserPrincipal;
import com.example.agentapp.auth.service.UserService;
import com.example.agentapp.common.dto.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {


    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserDTO>> getCurrentUser() {

        UserDTO user = userService.getCurrentUser();

        return ResponseEntity.ok(
                ApiResponse.success("User retrieved successfully", user)
        );
    }

    @PutMapping("/me")
    public ResponseEntity<ApiResponse<UserDTO>> updateProfile(
            Authentication authentication,
            @RequestBody Map<String, String> updates) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Long userId = userPrincipal.getId();

        UserDTO updatedUser = userService.updateProfile(
                userId,
                updates.get("firstName"),
                updates.get("lastName"),
                updates.get("phone")
        );

        return ResponseEntity.ok(
                ApiResponse.success("Profile updated successfully", updatedUser)
        );
    }

    @PostMapping("/me/change-password")
    public ResponseEntity<ApiResponse<Void>> changePassword(
            Authentication authentication,
            @Valid @RequestBody ChangePasswordRequest request) {

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Long userId = userPrincipal.getId();

        userService.changePassword(userId, request);

        return ResponseEntity.ok(
                ApiResponse.success("Password changed successfully")
        );
    }

    @DeleteMapping("/me")
    public ResponseEntity<ApiResponse<Void>> deleteOwnAccount(
            @RequestBody Map<String, String> request) {

        String password = request.get("password");

        userService.deleteOwnAccount(password);

        return ResponseEntity.ok(
                ApiResponse.success("Account deleted successfully")
        );
    }


    @GetMapping
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'MANAGER')")
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {

        List<UserDTO> users = userService.getAllUsers();

        return ResponseEntity.ok(
                ApiResponse.success("Users retrieved successfully", users)
        );
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'MANAGER')")
    public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable Long id) {

        UserDTO user = userService.getUserById(id);

        return ResponseEntity.ok(ApiResponse.success("User retrieved successfully", user));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {

        userService.softDeleteUser(id);

        return ResponseEntity.ok(
                ApiResponse.success("User deleted successfully")
        );
    }
}