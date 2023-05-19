package com.zenon.gestiondestock.validator;

import com.zenon.gestiondestock.dataTransferObject.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
  public  static List<String> validate(UtilisateurDto utilisateurDto){
      List<String> errors = new ArrayList<>();
      // on aimerait avoir les informations (obligatoire)importante de l'utilisateur
      if(utilisateurDto == null){
          errors.add("Nom d'utilisateur obligatoire");
          errors.add("Prénom d'utilisateur obligatoire");
          errors.add("Mot de passe de l'utilisateur obligatoire");
          errors.add("Adresse de l'utilisateur obligatoire");
          errors.add("Email de l'utilisateur obligatoire");
          return errors;
      }// si l'utilisateur est null

      if(!StringUtils.hasLength(utilisateurDto.getNomUtilisateur())){
          errors.add("Nom d'utilisateur obligatoire");
      }//Nom
      if(!StringUtils.hasLength(utilisateurDto.getPrenomUtilisateur())){
          errors.add("Prénom d'utilisateur obligatoire");
      }//Prenom
      if(!StringUtils.hasLength(utilisateurDto.getEmail())){
          errors.add("Email de l'utilisateur obligatoire");
      }//email
      if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
          errors.add("Mot de passe de l'utilisateur obligatoire");
      }//password

      if(utilisateurDto.getDateNaissance()== null){
          errors.add("veuillez renseigner la date de naissance de l'utilisateur");

      }//date de naissance
      //L'adresse avec toutes ses particularité
      if(utilisateurDto.getAdresse()== null){
          errors.add("Adresse de l'utilisateur obligatoire");
      }else{
          if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
              errors.add("Le champs 'adresse1' est obligatoire");
          }
          if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
              errors.add("Le champs 'Ville' est obligatoire");
          }
          if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostal())){
              errors.add("Le champs 'Code Postal' est obligatoire");
          }
          if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
              errors.add("Le champs 'Pays' est obligatoire");
          }

      }//else


      return errors;

  }
}
