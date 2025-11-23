
    
        // --- Lógica de Interfaz (Frontend Only) ---

        // 1. Control del Menú Móvil
        const menuBtn = document.getElementById('menu-btn');
        const mobileMenu = document.getElementById('mobile-menu');
        
        menuBtn.addEventListener('click', () => {
            mobileMenu.classList.toggle('hidden');
        });

        // 2. Control del Dropdown de Usuario (Desktop)
        const userMenuBtnDesktop = document.getElementById('userMenuBtnDesktop');
        const userMenuDesktopDropdown = document.getElementById('userMenuDesktopDropdown');

        if(userMenuBtnDesktop) {
            userMenuBtnDesktop.addEventListener('click', (e) => {
                e.stopPropagation();
                userMenuDesktopDropdown.classList.toggle('hidden');
            });

            // Cerrar dropdown al hacer click fuera
            document.addEventListener('click', (e) => {
                if (!userMenuBtnDesktop.contains(e.target) && !userMenuDesktopDropdown.contains(e.target)) {
                    userMenuDesktopDropdown.classList.add('hidden');
                }
            });
        }

        // 3. SIMULACIÓN DE ESTADO (LOGUEADO VS NO LOGUEADO)
        // Cambia esto a 'true' para ver cómo se ve la página cuando el usuario ha iniciado sesión
        const usuarioEstaLogueado = false; 

        function actualizarEstadoAuth() {
            const guestDesktop = document.getElementById('desktop-auth-guest');
            const userDesktop = document.getElementById('desktop-auth-user');
            const guestMobile = document.getElementById('mobile-auth-guest');
            const userMobile = document.getElementById('mobile-auth-user');

            if (usuarioEstaLogueado) {
                // Mostrar elementos de usuario, ocultar de invitado
                if(guestDesktop) guestDesktop.classList.add('hidden');
                if(userDesktop) userDesktop.classList.remove('hidden');
                if(guestMobile) guestMobile.classList.add('hidden');
                if(userMobile) userMobile.classList.remove('hidden');
            } else {
                // Mostrar elementos de invitado, ocultar de usuario
                if(guestDesktop) guestDesktop.classList.remove('hidden');
                if(userDesktop) userDesktop.classList.add('hidden');
                if(guestMobile) guestMobile.classList.remove('hidden');
                if(userMobile) userMobile.classList.add('hidden');
            }
        }

        // Ejecutar simulación al cargar
        actualizarEstadoAuth();

        // Función helper para el botón de logout
        function logoutSimulado() {
            alert("Cerrando sesión (Simulación)");
            // Aquí redirigirías normalmente a index.html o login.html
            window.location.href = "index.html"; 
        }