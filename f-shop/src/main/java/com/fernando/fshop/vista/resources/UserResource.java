/**
 * 
 */
package com.fernando.fshop.vista.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fernando.fshop.model.Users;
import com.fernando.fshop.negocio.services.UserService;
import com.fernando.fshop.vista.vo.UserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el servicio web de user
 * 
 * @author Fernando Ambrosio
 *
 */
@RestController
@RequestMapping("/api/user")
@Api(tags = "user")
public class UserResource {

	private final UserService userService;

	/**
	 * Constructor por defecto para poder utilizar los servicios en la clase
	 * 
	 * @param userService
	 */
	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	@ApiOperation(value = "Crear Usuario", notes = "Servicio para crear un nuevo usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<Users> createUser(@RequestBody UserVO userVo) throws Exception {
		Users users = new Users();
		users.setFirstNameUser(userVo.getFirstNameUser());
		users.setLastNameUser(userVo.getLastNameUser());
		users.setEmailUser(userVo.getEmailUser());
		users.setUserName(userVo.getUserName());
		users.setPasswordUser(userVo.getPasswordUser());
		return new ResponseEntity<>(this.userService.create(users), HttpStatus.CREATED);
	}

	@PutMapping("/idUser")
	@ApiOperation(value = "Actualizar un usuario", notes = "Servicio para actualizar un usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario actualizado correctmente"),
			@ApiResponse(code = 404, message = "Usuario no encontrado") })
	public ResponseEntity<Users> updateUser(@PathVariable("idUser") String idUser, UserVO userVo) {
		Users users = this.userService.findByIdentificacion(idUser);
		if (users == null) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		} else {
			users.setFirstNameUser(userVo.getFirstNameUser());
			users.setLastNameUser(userVo.getLastNameUser());
			users.setEmailUser(userVo.getEmailUser());
			users.setUserName(userVo.getUserName());
			users.setPasswordUser(userVo.getPasswordUser());
		}
		return new ResponseEntity<>(this.userService.update(users), HttpStatus.OK);

	}

	@DeleteMapping("/idUser")
	@ApiOperation(value = "Eliminar un usuario", notes = "Servicio para eliminar un usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario eliminado correctamente"),
			@ApiResponse(code = 404, message = "Usuario no encontrado") })
	public void removeUser(@PathVariable("idUser") String idUser) {
		Users users = this.userService.findByIdentificacion(idUser);
		if (users != null) {
			this.userService.delete(users);
		}
	}

	@GetMapping
	@ApiOperation(value = "Listar Usuarios", notes = "Servicio para listar todos los usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuarios encontrados correctamente"),
			@ApiResponse(code = 404, message = "Usuarios no encontrados") })
	public ResponseEntity<List<Users>> findAll() {
		return ResponseEntity.ok(this.userService.findAll());
	}

}







