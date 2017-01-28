// js/prototype.js
'use strict';


/**
 * Déclaration de l'application demoApp
 */
var demoApp = angular.module('demoApp', [
    // Dépendances du "module"
    'placeHolder'
]);

/**
 * Déclaration du module todoList
 */
var todoList = angular.module('placeHolder',[]);


/**
 * Contrôleur de l'application "Todo List" décrite dans le chapitre "La logique d'AngularJS".
 */
todoList.controller('placeCtrl', function ($scope, $http) {

		// Pour manipuler plus simplement les places au sein du contrôleur
	    // On initialise les places avec un tableau vide : []
	    var places = $scope.places = [];

        // Ajouter un todo
        $scope.addPlace = function () {
            // .trim() permet de supprimer les espaces inutiles
            // en début et fin d'une chaîne de caractères
            var newPlace = $scope.newPlace.trim();
            if (!newPlace.length) {
                // éviter les places vides
                return;
            }
            
            // Construction de la place à ajouter
            var placeToAdd = {
                    // on ajoute la place au tableau des places
                    name: newPlace
            };
           
            // Enregistrement back-end
            $http.post("/place", placeToAdd)
            .then(function(response) { 
            	// Ajout dans la liste
            	response.data.displayed = true;
            	places.push(response.data);
                // Réinitialisation de la variable newPlace
                $scope.newPlace = '';
            })
            .catch(function(error) {
            	console.log('There has been a problem with your fetch operation: ' + error.message);
            });
            
            
        };

        // Enlever une place
        $scope.removePlace = function (place) {
        	// Suppression back-end
        	$http.delete(place._links.place.href)
            .then(function(myBlob) { 
            	// Retrait de la liste
            	places.splice(places.indexOf(place), 1);
            })
            .catch(function(error) {
            	console.log('There has been a problem with your fetch operation: ' + error.message);
            });
        };

        // Cocher / Décocher tous les places
        $scope.markAll = function (displayed) {
        	places.forEach(function (place) {
                place.displayed = displayed;
            });
        };

        // Enlever tous les places cochés
        $scope.clearDisplayedPlaces = function () {
        	places.forEach(function (place) {
        		if(place.displayed){
        			$scope.removePlace(place);
        		}
            });
        };
        
        $scope.allChecked = true;
        // Chargement des places depuis le back-end
        $http.get('/place').
        then(function(response) {
        	response.data._embedded.place.forEach(function (place) {
	        	place.displayed = true;
	        	$scope.places.push(place);
            });
	    });
        
    });